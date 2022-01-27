package com.geekbrains.cloud.jan.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Buffers {
    public static void main(String[] args) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(15);


       ByteBuffer str = ByteBuffer.wrap("Hello world".getBytes(StandardCharsets.UTF_8));

        buffer.put("Hello world".getBytes(StandardCharsets.UTF_8));
        buffer.flip();


            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            buffer.mark();
            System.out.println();

            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());

            buffer.reset();
            System.out.println();
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());



//        buffer.rewind();
//
//        while (buffer.hasRemaining()) {
//            System.out.println((char) buffer.get());
//        }

        RandomAccessFile raf = new RandomAccessFile("Data/file.txt", "rw");
        FileChannel channel = raf.getChannel();
//        channel.write(str, 17);

        buffer.clear();

        while (true){
            int readCount = channel.read(buffer);
            if (readCount == -1){
                break;
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        }
        System.out.println();


//        channel.position(3);
//        buffer.clear();
//        channel.read(buffer);
//
//        buffer.flip();


    }
}
