package alpha.ch14;

import java.util.Arrays;

public class BoundedClassReferences {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(args));
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;

    }
}
