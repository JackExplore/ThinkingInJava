package alpha.ch21;

import alpha.ch21.aThread.LiftOff;

public class BasicThrads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff !");
    }
}
