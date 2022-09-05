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
    }
    bike(float km,int number,double price){
        this.number=number;
        this.km= km;
        this.price=price;
    }
}
public class Basic {
    public static void main(String[] args) {
        bike b1=new bike();
        bike b2=new bike(34);
        bike b3=new bike(45,34,678);
        System.out.println(b1.km);
        System.out.println(b3.km);
        System.out.println(b2.km);
    }
}
