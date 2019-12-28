package alpha.ch18io.enio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Endians {
    public static void main(String[] args) {

        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        System.out.print("Default : \t" + Arrays.toString(bb.array()));
        bb.rewind();
        System.out.println();

        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.print("Big : \t\t" + Arrays.toString(bb.array()));
        bb.rewind();
        System.out.println();

        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.print("Little : \t" + Arrays.toString(bb.array()));
        bb.rewind();
    }
}
