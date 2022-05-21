package DynamicProgramming.Array;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
       int price[]={2,3,4,5};
       int N=6 ;
        int dp[][]=new int[N][N+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        System.out.println(memo(price, price.length-1, N-1,dp));
    }
    static int rodCutting(int[]prices,int n,int index){
        if (index==0){
            return n*prices[index];
        }
        int not_take=rodCutting(prices, n, index-1);
        int take=Integer.MIN_VALUE;
        int rodLength = index+1;
        if(rodLength<=n)take=prices[index]+rodCutting(prices, n-rodLength, index);
        return Math.max(take,not_take);
    }
    static int memo(int[] price, int ind, int N,int[][] dp){

        if(ind == 0){
            return N*price[0];
        }

        if(dp[ind][N]!=-1)
            return dp[ind][N];

        int notTaken = memo(price,ind-1,N,dp);

        int taken = Integer.MIN_VALUE;
        int rodLength = ind+1;
        if(rodLength <= N)
            taken = price[ind] + memo(price,ind,N-rodLength,dp);

        return dp[ind][N] = Math.max(notTaken,taken);
    }
}
