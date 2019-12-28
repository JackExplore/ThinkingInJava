package alpha.ch21.demo;

import alpha.ch13.Ch21TestInterface;

interface interA{
    int a_int = 1;

    String sameMethod(String s);
}

interface  interB{
    int a_int = 0;

    String sameMethod(String s);
}

public class TestInterface implements interA, interB, Ch21TestInterface {

    public String sameMethod(String s){
        return "hello:";
    }

//    public void sameMethod(String s){
//
//    }
    public static void main(String[] args) {
        TestInterface testInterface = new TestInterface();
        System.out.println(testInterface);
    }
}
