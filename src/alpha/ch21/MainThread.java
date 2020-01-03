package alpha.ch21;

import alpha.ch21.aThread.LiftOff;

public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff(10);
        launch.run();
    }
}
