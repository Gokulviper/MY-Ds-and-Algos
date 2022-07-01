package String.SlidingWindow;

import java.util.Scanner;

public class Gk {
    public static void main(String[] args) {
       int n=12;
        System.out.println(getMin(n,1));
    }

    private static int getMin(int n, int i) {
        if (n<0){
            return 0;
        }
       // if (n==0)return 1;
       int same=getMin(n-i*i,i);
        int increment=getMin(n-i*i,i+1);
        return 1+Math.max(same,increment);
    }
}
