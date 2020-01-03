package alpha.ch21.dShare;

public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public static int nextSerialNumber(){
        return serialNumber++;  // not thread-safe
    }
}
