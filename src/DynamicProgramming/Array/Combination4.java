package DynamicProgramming.Array;

import java.util.Arrays;

class Combination4 {
    public static void main(String[] args) {
        int[]nums={1,2,3};
        System.out.println(combinationSum4(nums,4));
    }
    public static int combinationSum4(int[] nums, int target) {
        int[]dp=new int[target+1];
        Arrays.fill(dp,-1);
        return f(nums,target,nums.length-1,dp);
    }
    static  int  f(int[]nums,int target,int j,int[]dp){
     if(target==0)return 1;
      int count=0;
    //    if(dp[target]==-1){
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target)
            count+=f(nums,target-nums[i],0,dp);
        }
           return count;
     //   }
     //   return dp[target];
    }
}