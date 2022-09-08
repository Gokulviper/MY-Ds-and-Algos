package OOP;

public interface emp extends Extemd,Another  {
  abstract    void salary();
    public default void name(){
        System.out.println("hi");
    }

}
