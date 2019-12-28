package alpha.ch5;

public class ClassLoad {
    int intA = intAMethod();

    static int intB = staticIntBMethod();

    public ClassLoad(){
        System.out.println("7 This is HelloWorld()");
    }

    public int intAMethod(){
        System.out.println("6 intA Method...");
        return 0;
    }
    public static int staticIntBMethod(){
        System.out.println("1 static intBMethod...");
        return 1;
    }
    public static int staticIntCMethod(){       // 无调用
        System.out.println("static intCMethod...");
        return 2;
    }
    static {
        System.out.println("2 static D block...");
    }

    public void EMethod(){
        System.out.println("8 E Method...");
    }

    public void FMethod(){                      // 无调用
        System.out.println("F Method...");
    }

    public static void main(String[] args) {
        System.out.println("5 This is HelloWorld!");
        new ClassLoad().EMethod();
    }

    static {
        System.out.println("3 static G block...");
    }

    static int intH = staticIntHMethod();

    public static int staticIntHMethod(){       // 无调用
        System.out.println("4 static intHMethod...");
        return 3;
    }
}

/** out:
 1 static intBMethod...
 2 static D block...
 3 static G block...
 4 static intHMethod...
 5 This is HelloWorld!
 6 intA Method...
 7 This is HelloWorld()
 8 E Method...
 */
