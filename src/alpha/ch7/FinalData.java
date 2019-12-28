package alpha.ch7;

public class FinalData {

    final int i;

    public FinalData(){
        i = 0;
    }

    int g(final int j){
        return i;
    }
}
