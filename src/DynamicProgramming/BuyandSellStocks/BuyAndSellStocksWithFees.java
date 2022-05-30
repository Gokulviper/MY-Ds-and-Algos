package DynamicProgramming.BuyandSellStocks;

class BuyAndSellStocksWithFees {
    //after finish your tansaction less fees
    public int maxProfit(int[] nums, int fee) {
         int[][]dp=new int[nums.length+1][2];
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = 0; j <dp[0].length ; j++) {
                int profit=0;
                if (j==1){
                    profit=Math.max(-nums[i]+dp[i+1][0],dp[i+1][1]);
                }else {
                    profit=Math.max(nums[i]-fee+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }

        }
        return dp[0][1];
    }
}