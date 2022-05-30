package DynamicProgramming.BuyandSellStocks;

import java.util.Arrays;

public class BuyAndSellStocksWithCoolDown {
    public int maxProfit(int[] nums) {
        int[][]dp=new int[nums.length][2];
        for(int[] num:dp) Arrays.fill(num,-1);
        return f(nums,0,1,dp);
    }
    int f(int[]nums,int i,int buy,int[][]dp){
        if(i>=nums.length)return 0;
        if(dp[i][buy]==-1){
            if(buy==1){
                dp[i][buy]= Math.max(-nums[i]+f(nums,i+1,0,dp),f(nums,i+1,1,dp));
            }else
                dp[i][buy]= Math.max(nums[i]+f(nums,i+2,1,dp),f(nums,i+1,0,dp));
        }
        return dp[i][buy];
    }
    public int tabulation(int[] nums) {
        //beacuse you going i+2 so maeke sure its n+2
        int[][]dp=new int[nums.length+2][2];


        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<2;j++){

                if(j==1){
                    dp[i][j]= Math.max(-nums[i]+dp[i+1][0],dp[i+1][1]);
                }else
                    dp[i][j]= Math.max(nums[i]+dp[i+2][1],dp[i+1][0]);
            }
        }
        return dp[0][1];
    }
    public int RemoveInnerloop(int[] nums) {
        //we remove the inner loop because the table has one and 0 so we dont make a loop
        //beacuse you going i+2 so maeke sure its n+2
        int[][]dp=new int[nums.length+2][2];

        for(int i=nums.length-1;i>=0;i--){
            dp[i][1]= Math.max(-nums[i]+dp[i+1][0],dp[i+1][1]);
            dp[i][0]= Math.max(nums[i]+dp[i+2][1],dp[i+1][0]);

        }
        return dp[0][1];
    }
}
