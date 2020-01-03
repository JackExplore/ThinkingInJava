package alpha.ch21.aThread;

public class BasicThreads {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();

        System.out.println("Waiting for LiftOff !");
    }
}
