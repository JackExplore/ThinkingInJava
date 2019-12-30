package alpha.ch21.aThread;

public class LiftOff implements Runnable {
    protected int countDown = 10;   // Default
    private static int taskcount = 0;
    private final int id = taskcount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
