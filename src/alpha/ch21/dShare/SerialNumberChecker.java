package alpha.ch21.dShare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 每次输出的结果数量都不一致：分析原因！
 *      System.out.println("Duplicate : " + serial);
 *      System.exit(0);
 * 这两句话之间线程被挂起，上下文切换！
 */
class CircularSet{

    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size){
        array = new int[size];
        len = size;
        // init
        for(int i=0; i<size; i++){
            array[i] = -1;
        }
    }

    public synchronized void add(int i){
        array[index] = i;
        // Wrap index and write over old elements :
        index = ++index % len;
    }

    public synchronized boolean contains(int val){
        for(int i=0; i<len; i++){
            if(array[i] == val) return true;
        }
        return false;
    }
}

public class SerialNumberChecker {

    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable{
        @Override
        public void run() {
            while(true){
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)){
                    System.out.println("Duplicate : " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception{

        for(int i=0; i<SIZE; i++){
            exec.execute(new SerialChecker());
        }
        // stop after n seconds if there's an argument :
//        if(args.length > 0){
        TimeUnit.SECONDS.sleep(new Integer(50));
        System.out.println("No duplicates detected.");
        System.exit(0);
//        }

    }
}
