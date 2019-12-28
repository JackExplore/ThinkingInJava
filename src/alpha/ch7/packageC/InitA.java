package alpha.ch7.packageC;

public class InitA {

    static int tempA = getLoadFlag();

    public static int getLoadFlag(){
        System.out.println("InitA : getLoagFlag()");
        return 1;
    }
}
