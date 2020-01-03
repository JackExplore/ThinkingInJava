package alpha.ch21.zDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果你将一个域声明为 volatile 的，那么只要对这个域产生了写操作，那么所有的读操作就都可以看到这个修改；
 * 即便使用了本地缓存，情况也确实如此， volatile 域会立即被写入到主存中，而读取操作就发生在主存中。
 * 同步也会导致主存中刷新；
 *
 * 另外，一个任务所做的任何写入操作对这个任务来说都是可视的。，
 * 因此，如果它只需要在这个任务内部可视，那么你就不需要将其设置为 volatile 的。
 */
class NonVolatile{
    int nonValue = 0;
//    volatile int nonValue = 0;      //
}


public class TestVolatile implements Runnable{

    static NonVolatile var = new NonVolatile();

    @Override
    public void run() {
        while(true){
            if(var.nonValue != 0){
                System.out.println("Thread " + System.currentTimeMillis() + " nonValue changed !");
                break;
            }


        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new TestVolatile());
        exec.shutdown();

        Thread.sleep(1000);
        TestVolatile.var.nonValue = 1;
        System.out.println("Main : " + System.currentTimeMillis() + " TestVolatile.var.nonValue = " + TestVolatile.var.nonValue);

        while(true){
            Thread.sleep(5000);
            System.out.println("Thread isTerminated() : " + exec.isTerminated());
        }
    }
}
