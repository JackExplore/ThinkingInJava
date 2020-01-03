package alpha.ch21.zDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS {

//    public static int count = 0;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<2; i++){
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for(int i=0; i<100; i++){
                        /**
                         * version A :
                         */
//                        count++;
                        /**
                         * version B :
                         */
//                        synchronized (TestCAS.class){
//                            count++;
//                        }

                        /**
                         * version C :
                         * 锁的执行过程，再查找学习！
                         */
                        count.incrementAndGet();
                    }
                }
            });
        }
        exec.shutdown();

        while(true){
            if(exec.isTerminated()){
                break;
            }
        }

        System.out.println("count = " + count);

    }
}
