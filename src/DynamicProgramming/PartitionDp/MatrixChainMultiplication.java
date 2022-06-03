package DynamicProgramming.PartitionDp;

import java.util.Arrays;

class MatrixChainMultiplication {
    public static void main(String[] args) {

    }
    static int matrixMultiplication(int N, int nums[])
    {
        int[][]dp=new int[N][N];
        for(int[]row:dp) Arrays.fill(row,-1);
        return memo(nums,1,N-1,dp);
    }
    
    static int memo(int[]nums,int i,int j,int[][]dp){
        if(i==j)return 0;
        if(dp[i][j]==-1){
        int min=(int)1e9;
        for(int k=i;k<j;k++){
            int steps=nums[i-1]*nums[k]*nums[j]+memo(nums,i,k,dp)+memo(nums,k+1,j,dp);
       min=Math.min(min,steps);
       dp[i][j]=min;
        }
        }
        return dp[i][j];
    }
}