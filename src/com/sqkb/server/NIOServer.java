package com.sqkb.server;

import com.sqkb.handle.NIOServerHandle;

/**
 * package: com.sqkb.Server
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2019-09-04 19:05
 */
public class NIOServer {

    private static NIOServerHandle nioServerHandle;

    public synchronized static void run() {
        if (nioServerHandle != null) {
            nioServerHandle.stop();
        }

        System.out.println("NIO Server start ...");

        nioServerHandle = new NIOServerHandle(12033);

        new Thread(nioServerHandle, "NIO Server").start();
    }
}
