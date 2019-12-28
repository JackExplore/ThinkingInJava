package alpha.ch14;

interface InterA{
    void f();
}

class FactA{
    void f(){
        System.out.println("FaceA f()");
    }
}

public class TestInterface extends FactA implements InterA{
    @Override
    public void f() {
        System.out.println("TestInterface f()");
    }

    public static void main(String[] args) {
        FactA testInterface = new TestInterface();
        testInterface.f();
    }
}
