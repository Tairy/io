package com.sqkb;

import com.sqkb.server.NIOServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        BIOServer.run();
//        BIOServerWithThreadPool.run();
        NIOServer.run();
    }
}
