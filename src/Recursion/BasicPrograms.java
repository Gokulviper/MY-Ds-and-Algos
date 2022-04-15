package Recursion;

public class BasicPrograms {
    public static void main(String[] args) {
        System.out.println(fibo(5));
    }

    private static void printNumbers(int n) {
        if (n<=0){
            return;
        }
        printNumbers(n-1);
        System.out.println(n);
    }
    private static int fibo(int n){
        if (n<2)return n;

       return  fibo(n-1)+  fibo(n-2);
    }
}

