package OOP;
class b{
      int a=0;
     private int b=12;
    public void ride(){
        System.out.println("bike is riding");
    }
}
class a extends b{
      public void get(){
          System.out.println("this class a");
      }
}
public class SingleIngeritence {
    public static void main(String[] args) {
     a aa=new a();
        System.out.println(aa.a);
       // System.out.println(aa.b);
    }
}

