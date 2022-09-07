package OOP;

public interface emp  {
  abstract    void salary();
    public default void name(){
        System.out.println("hi");
    }
    class a implements emp{
        public static void main(String[] args) {
            System.out.println("hi");
        }

        @Override
        public void salary() {

        }

        @Override
        public void name() {
            emp.super.name();
        }
    }

}
