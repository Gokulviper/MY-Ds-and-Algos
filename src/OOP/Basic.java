package OOP;
class  bike{
    int number;
    float km;
    double price;
   bike(int number){

        this.number=number;
        this.km= 34.5F;
        this.price=438d;
    }
    bike(){

        this.number=345;
        this.km= 57.5F;
        this.price=3454d;
        System.out.println("constructor");
    }
    bike(float km,int number,double price){
        this.number=number;
        this.km= km;
        this.price=price;
    }
}
public class Basic {
    static {
        int a=1;
        System.out.println(a);
    }
    public static void main(String[] args) {
        bike b1=new bike();
        bike b2=new bike(34);
        bike b3=new bike(45,34,678);
        m();
        System.out.println(b2.km);
        System.out.println("hellpw");
        int c=10,b=20;
        bike b4=new bike(c,34,678);

    }

    private static void m() {
        System.out.println("second");
    }
}
