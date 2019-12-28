package alpha.ch21;

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name, int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    public void run(){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(getName() + " was interrupted. " + isInterrupted());
        }
        System.out.println(getName() + " has awakened.");
    }

}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        }catch(InterruptedException e){
            System.out.println("Interrupted.");
        }
        System.out.println(getName() + " join completed.");
    }

}


public class Joining {

    public static void main(String[] args) {
        Sleeper sleeper1 = new Sleeper("sleepA", 1500);
        Sleeper sleeper2 = new Sleeper("sleepB", 2000);
        Joiner joiner1 = new Joiner("joinerA", sleeper1);
        Joiner joiner2 = new Joiner("joinerB", sleeper2);
        sleeper1.interrupt();
    }
}
