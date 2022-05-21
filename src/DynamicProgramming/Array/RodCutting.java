package DynamicProgramming.Array;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
       int price[]={2,3,4,5};
       int N= price.length;
        int dp[][]=new int[N][N+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        System.out.println(spaceOptmization(price, N));
    }
    private static int spaceOptmization(int[] price, int N) {
        int dp[][]=new int[N][N+1];
int[]prev=new int[N+1],cur=new int[N+1];


        for(int i=0; i<=N; i++){
           prev[i] = i*price[0];
        }

        for(int ind=1; ind<N; ind++){
            for(int length =0; length<=N; length++){

                int notTaken =  prev[length];

                int taken = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength <= length)
                    taken = price[ind] + cur[length-rodLength];

                cur[length] = Math.max(notTaken,taken);
            }
            prev=cur;
        }

        return prev[N];
    }

    private static int tabulation(int[] price, int N) {
        int dp[][]=new int[N][N+1];

        for(int row[]:dp)
            Arrays.fill(row,-1);

        for(int i=0; i<=N; i++){
            dp[0][i] = i*price[0];
        }


        for(int ind=1; ind<N; ind++){
            for(int length =0; length<=N; length++){

                int notTaken =  dp[ind-1][length];

                int taken = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength <= length)
                    taken = price[ind] + dp[ind][length-rodLength];

                dp[ind][length] = Math.max(notTaken,taken);
            }
        }

        return dp[N-1][N];
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
