package alpha.ch21;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

class InnerThread1{

    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }
        public void run(){
            try {
                while(true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    sleep(10);
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
    public InnerThread1(String name){
        inner = new Inner(name);
    }
}

class InnerRunnable1{
    private int countDown = 5;
    private Inner inner;
    private class Inner implements Runnable{
        Thread t;
        Inner(String name){
            t = new Thread(this, name);
            t.start();
        }
        @Override
        public void run(){
            try{
                while(true){
                    System.out.println(this);
                    if(--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }catch(InterruptedException ee){
                System.out.println("sleep() interrupted");
            }

        }

        public String toString(){
            return t.getName() + " : " + countDown;
        }
    }

    public InnerRunnable1(String name){
        inner = new Inner(name);
    }

}


class ThreadMethod{
    private int countDown = 5;
    private Thread t;
    private String name;
    public ThreadMethod(String name){
        this.name = name;
    }
    public void runTask() {
        if(t == null){
            t = new Thread(name){
                public void run(){
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) return;
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("eeeeeeeeeee");
                    }
                }
                public String toString(){
                    return getName() + " : " + countDown;
                }
            };
            t.start();
        }
    }
}

public class ThreadVariations {

    public static void main(String[] args) throws Exception{
        new InnerThread1("InnerThread1");
        sleep(100);
        new InnerRunnable1("InnerRunnable1");
        sleep(1000);
        new ThreadMethod("ThreadMethod").runTask();
    }

}
