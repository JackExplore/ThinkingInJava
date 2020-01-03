package alpha.ch21.eAtomic;

public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    // 要进行同步操作
    public /*synchronized*/ static int nextSerialNumber(){
        return serialNumber++;  // not thread-safe
    }
}
