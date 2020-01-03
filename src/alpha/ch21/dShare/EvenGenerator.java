package alpha.ch21.dShare;

import static java.lang.Thread.yield;

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    /**
     * 递增程序自身也需要多个步骤，并且在递增过程中任务可能会被线程机制挂起，
     * 也就是说，在Java中，递增不是原子性的操作。
     * @return
     */
    @Override
    public int next() {
        ++currentEvenValue;     // Danger point here !@
        yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
