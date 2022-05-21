package DynamicProgramming.Array;

import java.util.Arrays;

public class UnboundKnapsack {
    //this is problem you can take single element many times
    public static void main(String[] args) {
    int[]wei={4,5,7},val={1,2,4};
    int w=13;
        int[][] dp=new int[wei.length][w+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
       // System.out.println(unboundknapsack(wei,val,w,wei.length-1,dp));
        System.out.println(tabulation(wei,val,w));
    }
    static int singleArraySpaceOptimized(int n, int W, int[] val,int[] wt) {

        int cur[]=new int[W+1];

        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            cur[i] = ((int)i/wt[0]) * val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int j=0; j<=W; j++){

                int notTaken = cur[j];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= j)
                    taken = val[ind] + cur[j - wt[ind]];

                cur[j] = Math.max(notTaken, taken);
            }
        }

        return cur[W];

    }
    private static int spaceOptimized(int[] weights, int[] values, int w) {

        int[]prev=new int[w],cur=new int[w];
        for (int i = weights[0]; i <w; i++) {
            prev[i]=(i/weights[0])*values[0];
        }
        for (int i = 1; i < weights.length ; i++) {
            for (int j = 0; j <=w ; j++) {
                int not_take=prev[j];
                int take=Integer.MIN_VALUE;
                if(weights[i]<=j)take=values[i]+cur[j-weights[i]];
                cur[j]=Math.max(take,not_take);
            }
            prev=cur;
        }
        return prev[w];
    }


    private static int tabulation(int[] weights, int[] values, int w) {
        int[][]dp=new int[weights.length][w+1];
        for (int i = weights[0]; i <w; i++) {
             dp[0][i]=(i/weights[0])*values[0];
        }
        for (int i = 1; i < weights.length ; i++) {
            for (int j = 0; j <=w ; j++) {
                int not_take=dp[i-1][j];
                int take=Integer.MIN_VALUE;
                if(weights[i]<=j)take=values[i]+dp[i][j-weights[i]];
                dp[i][j]=Math.max(take,not_take);
            }
        }
        return dp[weights.length-1][w];
    }

    private static int memo(int[]weights,int[]values,int w,int i,int[][]dp){
        if (i==0){
            return (w/weights[0])*values[0];
        }
        if (dp[i][w]==-1) {
            int not_take = memo(weights, values, w, i - 1, dp);
            int take = Integer.MIN_VALUE;
            if (weights[i] <= w) take = values[i] + memo(weights, values, w - weights[i], i, dp);
            dp[i][w]= Math.max(not_take, take);
        }
        return dp[i][w];
    }
    private static int unboundedKnapsack(int[]weights, int[]values, int w, int i){
        if (i==0){
            return (w/weights[0])*values[0];
        }
            int not_take = unboundedKnapsack(weights, values, w, i - 1);
            int take = Integer.MIN_VALUE;
            if (weights[i] <= w) take = values[i] + unboundedKnapsack(weights, values, w - weights[i], i);
        return Math.max(not_take, take);
    }
}
