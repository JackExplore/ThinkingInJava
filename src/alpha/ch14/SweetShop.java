package alpha.ch14;

class Candy{
    static{
        System.out.println("Loading Candy");
    }
}

class Gum{
    static{
        System.out.println("Loading Gum");
    }
}
class Cookie{
    static{
        System.out.println("Loading Cookie");
    }
}
public class SweetShop {

    public static void main(String[] args) {
        System.out.println("Inside main");

        new Candy();
        System.out.println("After creating Candy");

//        try{
//            Class.forName("com.demo.thinking.ch14.Gum");
//        }catch(ClassNotFoundException e){
//            System.out.println("Couldn/t find Gum");
//        }

        System.out.println(Gum.class);

        System.out.println("After Class.forName(Gum)");
        new Cookie();
        System.out.println("After creating Cookie");
    }

}
