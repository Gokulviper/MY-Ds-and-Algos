package DynamicProgramming.Array;

import java.util.Arrays;

class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
    int[]num1=new int[nums.length-1];
         int[]num2=new int[nums.length-1];
        for(int i=0;i<num1.length;i++){
            num1[i]=nums[i];
        }
        int j=0;
        for(int i=1;i<nums.length;i++){
            num2[j++]=nums[j];
        }
        int[]dp=new int[nums.length-1];
            int[]dp1=new int[nums.length-1];
        Arrays.fill(dp,-1);Arrays.fill(dp1,-1);
        return Math.max(f(num1,num1.length-1,dp),f(num2,num2.length-1,dp1));
        
    }
    int f(int[]nums,int i,int[]dp){
        if(i<=0){
            return i==0?nums[0]:0;
        }
        if(dp[i]==-1){
        int npick=f(nums,i-1,dp);
        int pick=nums[i]+f(nums,i-2,dp);
        dp[i]= Math.max(pick,npick);
        }
        return dp[i];
    }
}