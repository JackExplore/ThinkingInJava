package alpha.ch7;

class Art{

    Art(int i){
        System.out.println("Art() " + i);
    }
    private void doS(){

    }
}

class Drawing extends Art{

    Art art = new Art(2);

    final void doS(){

    }

    Drawing(int i){
        super(i);
        System.out.println("Drawing()" + i);
    }
}

public class Cartoon extends Drawing{

    Art art = new Art(1);

//    void doS(){
//
//    }

    public Cartoon(int i){
        super(i);
        System.out.println("Cartoon()" + i);
    }

    public static void main(String[] args) {
        System.out.println("Begin ...");
        new Cartoon(0);
    }
}

/** out :
 * Art() 0
 * Art() 2
 * Drawing()0
 * Art() 1
 * Cartoon()0
 */