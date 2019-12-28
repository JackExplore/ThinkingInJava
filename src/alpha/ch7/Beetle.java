package alpha.ch7;

class Insect{

    private int i = 9;
    protected int j = printInit("?3/4 Insect.j initialized");
    Insect(){
        System.out.println("4 i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("1 static Insect.x1 initialized");
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect{

    private int k = printInit("5 Beetle.k initialized");
    public Beetle(){
        System.out.println("6 k = " + k);
        System.out.println("7 j = " + j);
    }

    private static int x2 = printInit("2 static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("3 Beetle constructor");
        Beetle b = new Beetle();
    }

}
/** out :
 * 1 static Insect.x1 initialized
 * 2 static Beetle.x2 initialized
 * 3 Beetle constructor
 * ?3/4 Insect.j initialized
 * 4 i = 9, j = 47
 * 5 Beetle.k initialized
 * 6 k = 47
 * 7 j = 39
 */
