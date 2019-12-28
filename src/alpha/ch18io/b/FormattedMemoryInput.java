package alpha.ch18io.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class FormattedMemoryInput {

    public static void main(String[] args) {

        try{
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("ThinkingInJava.iml").getBytes()
                    )
            );
            while(true){
                System.out.print((char) in.readByte());
            }
        }catch (Exception e){
            System.err.println("End of stream.");
        }
    }
}
