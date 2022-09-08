package OOP;
final class  check{
    public void is(){
        System.out.println("this final class");
    }
}
 class  clock {
   final public void is(){
        System.out.println("this final class");
    }
}
public class FinalExample extends clock {

     public static void main(String[] args) {
        final  int a=10;
        try {
            System.out.println(a/5);
        }catch (Exception e){
            System.out.println("error acquired");
        }finally {
            System.out.println("safed");
        }
         System.out.println("finsished");


    }
}
