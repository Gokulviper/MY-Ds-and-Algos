package OOP;
class h{
   static int a=10;
    int b=20;
    int c;
    h(int c){
        this.c=a+this.b+c;
    }
    public void samll(){

        System.out.println("first  class");
    }
}
class sub1 extends h{
    sub1(int c) {
        super(c);
    }
 public void sl(){
        System.out.println("second  class");
    }
}
class sub2 extends h{
    sub2(int c) {
        super(c);
    }

    public void sab(){
        System.out.println("third  class");
    }
}
public class HieraricalInheritance {
    public static void main(String[] args) {
        int a=234523453;
        long b=a;
        int c=(int)b;
        sub2 s=new sub2(67);
        sub1 s1=new sub1(67);
        System.out.println(s1.c);

    }

}
