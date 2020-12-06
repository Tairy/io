package com.sqkb.handle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * package: com.sqkb.handle
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2019-09-04 19:17
 */
public class NIOServerHandle implements Runnable {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean started;

    public NIOServerHandle(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();

            // 开启非阻塞模式
            serverSocketChannel.configureBlocking(false);

            // 绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);

            // 监听客户端连接请求
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            // 标记服务器已开启
            started = true;

            System.out.printf("NIO Server start at %d", port);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        started = false;
    }

    @Override
    public void run() {
        while (started) {
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();

                Iterator<SelectionKey> it = keys.iterator();

                SelectionKey key = null;

                while (it.hasNext()) {
                    key = it.next();
                    it.remove();

                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();

                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {

            // 处理新接入的请求消息
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();

                SocketChannel sc = ssc.accept();

                System.out.println("new connect created.");

                // 设置为非阻塞
                sc.configureBlocking(false);

                sc.register(selector, SelectionKey.OP_READ);
            }

            // 读消息

            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();

                // 创建缓冲区 buffer
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                // 读取请求码流，返回读取到的字节数
                int readBytes = sc.read(byteBuffer);

                if (readBytes > 0) {

                    // 将缓冲区当前的 limit 设置为 position=0，用户后续对缓冲区的读取操作
                    byteBuffer.flip();

                    // 根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[byteBuffer.remaining()];

                    // 将缓冲区数据复制到新创建的数组中
                    byteBuffer.get(bytes);

                    String expression = new String(bytes, StandardCharsets.UTF_8);

                    System.out.printf("server receive data: %s", expression);

                    String result = null;

                    try {
                        result = "received: " + expression;
                    } catch (Exception e) {
                        result = "message error: " + e.getMessage();
                    }

                    doWrite(sc, result);
                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel sc, String response) {
        try {
            byte[] bytes = response.getBytes();

            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

            writeBuffer.put(bytes);

            writeBuffer.flip();

            sc.write(writeBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
