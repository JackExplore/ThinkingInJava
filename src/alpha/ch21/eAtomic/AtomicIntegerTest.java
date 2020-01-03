package alpha.ch21.eAtomic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);
    public int getValue(){
        return i.get();
    }
    private void evenIncrement(){
        i.addAndGet(2);
    }
    @Override
    public void run() {
        while(true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        /**
         * 这里通过 AtomicInteger 而消除了 synchronized 关键字。
         * 因为这个程序不会失败，所以添加了一个 Timer ，以便在 5s 钟之后自动的终止。
         */
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);   // Terminate after 5 seconds

        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);

        while(true){
            int val = ait.getValue();
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
