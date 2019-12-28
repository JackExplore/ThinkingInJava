package alpha.ch7.packageB;

import alpha.ch7.packageA.Cleanser;

public class Detergent extends Cleanser {

    public void apply(){
        append(" D apply() ");
        super.apply();
    }

    public void foam(){
        append(" foam() ");
    }

    // Test the new class
    public static void main(String[] args) {
        Detergent de = new Detergent();
        de.dilute();
        de.apply();
        de.foam();
        System.out.println(de);
        Cleanser.main(args);
    }
}
