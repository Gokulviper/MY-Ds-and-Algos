package DynamicProgramming.PartitionDp;

import java.util.Arrays;

class MinimumCostCutAStick {
    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
            Arrays.sort(cuts);
        int[]nums=new int[len+2];
        for(int i=1;i<=cuts.length;i++){
            nums[i]=cuts[i-1];
        }
        nums[len+1]=n;
        int[][]dp=new int[len+1][len+1];
        for(int[]r:dp) Arrays.fill(r,-1);
        return cut(n,nums,1,len,dp);
    }
    int cut(int n,int[]nums,int i,int j,int[][]dp){
        if(i>j)return 0;
        if(dp[i][j]==-1){
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=nums[j+1]-nums[i-1]+cut(n,nums,i,k-1,dp)+
                cut(n,nums,k+1,j,dp);
            min=Math.min(min,cost);
        }
        dp[i][j]= min;
        }
        return dp[i][j];
    }
}