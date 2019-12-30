package alpha.ch18io.g.externalizable;

import java.io.*;

/**
 * Externalizable
 */
public class Blip3 implements Externalizable {

    private int i;
    private String s;   // no initialization
    public Blip3(){
        System.out.println("Blip3 Constructor");
    }
    public Blip3(String x, int a){
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
        // s & i initialized only in non-default constructor
    }
    public String toString(){ return s + i; }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        // you must do this ?
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Bli3.readExternal");
        // you must do this ?
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Constructing objects : ");
        Blip3 b3 = new Blip3("A String ", 47);
        System.out.println(b3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object : ");
        oos.writeObject(b3);
        oos.close();

        // now get it back
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3 :");
        b3 = (Blip3) ois.readObject();
        System.out.println(b3);
    }
}
