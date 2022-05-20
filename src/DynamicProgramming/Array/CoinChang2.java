package DynamicProgramming.Array;

import java.util.Arrays;

class CoinChang2 {
    public int change(int target, int[] nums) {
        int[][]dp=new int[nums.length][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
              return tablation(nums,target);
    }
    public int spaceOptimize(int target, int[] nums) {
        int[]prev=new int[target+1],cur=new int[target+1];
        int[][]dp=new int[nums.length][target+1];
        for (int i = 0; i <=target ; i++) {
            prev[i]=i%nums[0]==0?1:0;
        }
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <=target ; j++) {
                int not_take=prev[j];
                int take=0;
                if (nums[i]<=j)take=cur[j-nums[i]];
                cur[j]=take+not_take;
            }
            prev=cur;
        }
        return prev[target];
    }

    private int tablation(int[] nums, int target) {
        int[][]dp=new int[nums.length][target+1];
        for (int i = 0; i <=target ; i++) {
            dp[0][i]=i%nums[0]==0?1:0;
        }
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <=target ; j++) {
                int not_take=dp[i-1][j];
                int take=0;
                if (nums[i]<=j)take=dp[i][j-nums[i]];
                dp[i][j]=take+not_take;
            }
        }
        return dp[nums.length-1][target];
    }

    private int memo(int[]nums,int target,int i,int[][]dp){
      

        if(i==0){
            return target%nums[i]==0?1:0;
        }
        if(dp[i][target]==-1){
        int ntake=memo(nums,target,i-1,dp);
        int take=0;
        if(nums[i]<=target)take=memo(nums,target-nums[i],i,dp);
        dp[i][target]= ntake+take;
        }
        return dp[i][target];
    }
}