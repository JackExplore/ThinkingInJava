package alpha.ch21.dShare;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();    // Lock 对象必须被显示地创建、锁定和释放

    @Override
    public int next() {

        lock.lock();

        try{
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
            /**
             * return finally 疑惑：
             * P681  什么才属于原子操作？
             *       对域中的值做  赋值  和  返回操作  通常都是原子性的。
             */
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
