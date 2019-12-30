package alpha.ch18io.g.serializable;

import java.io.*;

public class SerialCtl implements Serializable {

    private String a;
    private transient String b;

    public SerialCtl(String aa, String bb){
        a = "Not Transient : " + aa;
        b = "Transient : " + bb;
    }

    @Override
    public String toString() {
        return "SerialCtl{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream stream) throws IOException{
        stream.defaultWriteObject();
        stream.writeObject(b);
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws Exception{

        SerialCtl sc = new SerialCtl("Test1", "Test2");

        System.out.println("Before : \n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);

        // now get it back
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After : \n" + sc2);
    }
}
