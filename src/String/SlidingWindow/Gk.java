package String.SlidingWindow;

import java.util.Arrays;

public class Gk {
    public static void main(String[] args) {
       int n=12;
       int min=Integer.MAX_VALUE;
       int[][]dp=new int[n+1][2*n+1];
       for(int row[]:dp) Arrays.fill(row,-1);
       // for (int i = 1; i <=12 ; i++) {
       //   min= Math.min(getMin(n,i,dp),min);
       //     for(int row[]:dp) Arrays.fill(row,-1);
       // }
        System.out.println(getMin(n,1,dp));

    }

    private static int getMin(int n, int i, int[][] dp) {
        if (n<0){
            return 0;
        }
       // if (n==0)return 1;
        if(dp[n][i]==-1) {
            int same = getMin(n - i * i, i, dp);
            int increment = getMin(n - i * i, i + 1, dp);
            dp[n][i]= 1 + Math.min(same, increment);
        }
        return dp[n][i];
    }
}
