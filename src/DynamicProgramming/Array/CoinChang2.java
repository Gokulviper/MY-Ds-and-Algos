package DynamicProgramming.Array;

import java.util.Arrays;

class CoinChang2 {
    public int change(int target, int[] nums) {
        int[][]dp=new int[nums.length][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
              return memo(nums,target,nums.length-1,dp);
    }
    private int memo(int[]nums,int target,int i,int[][]dp){
      
      //  if(target==0)return 1; 
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