package alpha.ch18io.enio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        if(args.length != 2){
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

        /**
         * buffer.flip()  &  buffer.clear()
         * 每次 read() 操作后，就会将数据输入到缓冲器中，flip() 则是准备缓冲器以便它的信息可以由 write() 提取；
         * 每次 write() 操作之后，信息仍在缓冲器中，接着 clear() 操作则对所有的内部指针重新安排，以便缓冲器在另一个 read() 操作期间能够做好接收数据的准备；
         */
        while(in.read(buffer) != -1){
            buffer.flip();  // Prepare for waiting
            out.write(buffer);
            buffer.clear(); // Prepare for reading
        }
    }
}
