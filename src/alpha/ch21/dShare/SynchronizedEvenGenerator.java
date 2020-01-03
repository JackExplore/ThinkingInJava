package alpha.ch21.dShare;

import static java.lang.Thread.yield;

public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    /**
     * 第一个进入 next() 的任务将获得锁，任何其他试图获取锁的任务都将从其开始尝试之时被阻塞，直至第一个任务释放锁。
     * 通过这种方式，任何时刻只有一个任务可以通过由  互斥量  看护的代码。
     * @return
     */
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
