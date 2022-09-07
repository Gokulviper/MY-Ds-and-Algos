package OOP;

abstract public class Abstraction {

    abstract  public void start();
    abstract  public  void df();
    abstract  public void dg();
    abstract  public void dgk();
    abstract  public void fg();

}
class blend extends Abstraction{
    public static void main(String[] args) {
        emp e= new emp() {
            @Override
            public void salary() {

            }

            @Override
            public void name() {
                emp.super.name();
            }
        };
        e.name();

    }

    @Override
    public void start() {

    }

    @Override
    public void df() {

    }

    @Override
    public void dg() {

    }

    @Override
    public void dgk() {

    }

    @Override
    public void fg() {

    }
}
