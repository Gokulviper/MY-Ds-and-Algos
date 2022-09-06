package OOP;
class  raj{
   public void name(){
       System.out.println("raj");
   }
}
class gokul extends raj{
    public void work(){
        System.out.println("software enginer");
    }
}
class arun extends gokul{
    public void get(){
        System.out.println("what the fuck");
    }
    public void work(){
        System.out.println("overided");
    }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        arun a=new arun();
        a.name();
        a.work();

    }
}
