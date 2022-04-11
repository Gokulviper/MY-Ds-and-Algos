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
        if (n<0)return 0;
        int left=fibo(n-1);
        int right=fibo(n-2);
        return left+right;
    }
}

