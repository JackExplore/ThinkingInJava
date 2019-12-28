package alpha.ch10;

public class DotNew {

    public class Inner{}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        Inner dni = dn.new Inner();
    }
}
