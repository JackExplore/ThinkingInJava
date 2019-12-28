package alpha.ch20;

public class Testable {

    static{
        System.out.println("Hello, this is Testable static area!");
    }

    public void execute(){
        System.out.println("Executing...");
    }

    @Test
    void testExecute(){
        execute();
    }
}
