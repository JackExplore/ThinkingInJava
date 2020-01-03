package alpha.ch21.bExecutor;

import alpha.ch21.aThread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i=0; i<5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
