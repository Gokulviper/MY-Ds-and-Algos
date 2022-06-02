package DynamicProgramming.Array;

import java.util.Arrays;

class HouseRobber2 {
    public int tabulation(int[] nums) {
        if(nums.length==1)return nums[0];

        int[]num1=  Arrays.copyOfRange(nums,0,nums.length-2);
        int[]num2=  Arrays.copyOfRange(nums,1,nums.length-1);
        int[]dp=new int[nums.length-1];
        int[]dp1=new int[nums.length-1];
        dp[0]=nums[0];
        dp1[0]=nums[1];
        for(int i=1;i<num1.length;i++){
            int npick=dp[i-1];
            int pick=0;
            if(i>1)pick=num1[i]+dp[i-2];
            dp[i]=Math.max(pick,npick);
        }
        for(int i=1;i<num2.length;i++){
            int npick=dp1[i-1];
            int pick=0;
            if(i>1)pick=num2[i]+dp1[i-2];
            dp1[i]=Math.max(pick,npick);
        }
        return Math.max(dp1[num1.length-1],dp[num2.length-1]);
    }
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