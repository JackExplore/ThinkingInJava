package alpha.ch10;

public class DotThis {

    void f(){
        System.out.println("DotThis.f()");
    }

    public class Inner{
        private int k = 1;
        public DotThis outer(){
            return DotThis.this;
        }
        public void showK(){
            System.out.println("k = " + k);
        }
    }

    public Inner inner(){
        Inner in = new Inner();
        in.k++;
        return in;
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner dti = dt.inner();
        dti.outer().f();
        dti.showK();
    }
}
