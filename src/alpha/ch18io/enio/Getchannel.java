package alpha.ch18io.enio;

import alpha.ch18io.b.FileOutputShortcut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Getchannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // Write a file :
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes())); // wrap() 将已经存在的字节数组 “包装” 到 ByteBuffer 中
        fc.close();

        // Add to the end of the file :
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size()); // move the the end
        fc.write(ByteBuffer.wrap("Some more ".getBytes()));
        fc.close();

        // Read the file :
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
    }
}
