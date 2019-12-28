package alpha.ch17;

public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("s1 hashcode : " + s1.hashCode());
        System.out.println("s2 hashcode : " + s2.hashCode());
        System.out.println("s1 == s2 : " + (s1 == s2));
        System.out.println("s1.equals(s2) : " + s1.equals(s2));
    }
}
/* out:
69609650
69609650
s1 hashcode : 99162322
s2 hashcode : 99162322
s1 == s2 : false
s1.equals(s2) : true
 */