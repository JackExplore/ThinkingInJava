package alpha.ch18io.enio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件锁对其他的操作系统进程是可见的，因为 Java 的文件加锁直接映射到了 本地操作系统的加锁工具
 *
 * tryLock() 是非阻塞式的，它设法获取锁，但是如果不能获得，它将直接从方法调用返回；
 * lock() 则是阻塞式的，它要阻塞进程直至锁可以获得，或线程中断or关闭。
 *
 *
 */
public class FileLocking {
    public static void main(String[] args) {

        FileOutputStream fos = null;
        FileLock fl = null;
        try {
            fos = new FileOutputStream("file.txt");
            fl = fos.getChannel().tryLock();

            if(fl != null){
                System.out.println("Locked file");
                TimeUnit.MICROSECONDS.sleep(100);
                fl.release();
                System.out.println("Realeased Lock");
            }
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
