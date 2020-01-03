package alpha.ch21.bExecutor;

import alpha.ch21.aThread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

    @Override
    public void run() {
        try{
            while(countDown-- > 0){
                System.out.println(status());
                // old style
                // Thread.sleep(100);
                // Java 5/6 style
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){    // 异常不能跨线程传播回 main()，所以必须在本地处理所有在任务内部产生的异常
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
