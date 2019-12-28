package alpha.ch21;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable {
    @Override
    public void run() {
        try{
            System.out.println("Starting ADaemon...");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException.");
        }finally{
            System.out.println("This should always run ?");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        Thread.sleep(500);
    }
}
