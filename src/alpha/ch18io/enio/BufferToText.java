package alpha.ch18io.enio;

import sun.java2d.pipe.BufferedBufImgOps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {

        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        // does not work
        System.out.println("is it work : " + buff.asCharBuffer());

        // decode using this system's default charset:
        buff.rewind();  // 返回到数据开始部分
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + " : " + Charset.forName(encoding).decode(buff));

        // Or , we could encode with something that will print
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        // Now try reading again:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("write with encode : " + buff.asCharBuffer());

        // Use a Charbuffer to write through:
        fc = new FileOutputStream("data2.txt").getChannel();
        buff = ByteBuffer.allocate(24); // more than needed
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        // read and display
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("write & read asCharBuffer : " + buff.asCharBuffer());

    }
}
