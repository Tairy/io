package com.sqkb;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        RequestIDGenerator requestIDGenerator = new RequestIDGenerator();
//        RequestIDGenerator

//        RequestIDGenerator.getInstance().nextId();

        for (int i = 0; i < 100; i++) {
            System.out.printf("next_id: %s\n", RequestIDGenerator.getInstance().nextId());
        }
    }
}
