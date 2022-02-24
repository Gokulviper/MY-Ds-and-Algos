package Math;

public class WorkingWithOperators {
    public static void main(String[] args) {
        System.out.println(removeLastDigit(121));
    }

    private static int removeLastDigit(int num) {
        return num/10;
    }


    private static int giveTheHalfOfTheNumber(int num) {
        return num>>1;
    }

    public static void EvenOrOdd(int num){
        //every number AND with one digits will remains same
        //
        if((num&1)==1){
            System.out.println("odd");
        }else{
            System.out.println("even");
        }

    }
    public  static int DoubleNumber(int num){
        return num<<1;
    }
}
