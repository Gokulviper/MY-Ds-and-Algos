package DynamicProgramming.BuyandSellStocks;

import java.util.Arrays;

class BuyAndSellStocks2 {
    public static void main(String[] args) {

    }
    public int spaceOptimized(int[] nums) {
        // int[][]dp=new int[nums.length+1][2];
        int[]prev=new int[2],cur= new int[2];
        //instead of using 2 size 2 arrays you can use 4 varibles
        //but incalculation of time complextiy it should be same
        //this is fixed sized array
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = 0; j <2 ; j++) {
                int profit=0;
                if (j==1){
                    profit=Math.max(-nums[i]+prev[0],prev[1]);
                }else {
                    profit=Math.max(nums[i]+prev[1],prev[0]);
                }
                cur[j]=profit;
            }
            prev=cur;

        }
        return prev[1];
    }
    int tabulation(int[]nums){
        int[][]dp=new int[nums.length+1][2];
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = 0; j <dp[0].length ; j++) {
                int profit=0;
                if (j==1){
                    profit=Math.max(-nums[i]+dp[i+1][0],dp[i+1][1]);
                }else {
                    profit=Math.max(nums[i]+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }

        }
        return dp[0][1];
    }
    public  int memo(int[]nums,int buy,int i,int[][]dp){
        if (i== nums.length)return 0;
        int profit=0;
        if(dp[i][buy]==-1){
            if (buy==1){
                profit=Math.max(-nums[i]+memo(nums, 0, i+1,dp),memo(nums, 1, i+1,dp));
            }else {
                profit=Math.max(nums[i]+memo(nums, 1, i+1,dp),memo(nums, 0, i+1,dp));
            }
            dp[i][buy]=profit;
        }
        return dp[i][buy];
    }
    public  int maxp(int[]nums,int buy,int i){
if (i== nums.length)return 0;
   int profit=0;
   if (buy==1){
       profit=Math.max(-nums[i]+maxp(nums, 0, i+1),maxp(nums, 1, i+1));
   }else {
       profit=Math.max(nums[i]+maxp(nums, 1, i+1),maxp(nums, 0, i+1));
   }
   return profit;
    }
    public int maxProfit(int[] nums) {
        int sellday=nums[0];
        int buyday=nums[0];
        int p=0;
        int i=0;
        while(i<nums.length-1){
            while(i<nums.length-1&&nums[i]>=nums[i+1]){
                i+=1;
            }
            buyday=nums[i];
            while(i<nums.length-1&&nums[i]<=nums[i+1]){
            i+=1;
            }
            sellday=nums[i];
            p+=Math.abs(sellday-buyday);
        }
        return p;
    }
}