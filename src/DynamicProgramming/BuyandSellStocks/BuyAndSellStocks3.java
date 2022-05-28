package DynamicProgramming.BuyandSellStocks;

class BuyAndSellStocks3 {
    public static void main(String[] args) {
        int nums[]={5,76,9,9,44};
        int[][][]dp=new int[nums.length][2][3];
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <2 ; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k]=-1;
                }
            }
        }
        memo(nums,2,0,1,dp);
    }
  public  static int memo(int[]nums,int cap,int i,int buy,int[][][]dp) {
      if (i == nums.length || cap == 0) return 0;
      if (dp[i][buy][cap] == -1) {

          if (buy == 1) {
              dp[i][buy][cap]= Math.max(-nums[i] + memo(nums, cap, i + 1, 0, dp),
                      memo(nums, cap, i + 1, 1, dp));
          }else
          dp[i][buy][cap] =Math.max(nums[i] + memo(nums, cap - 1, i + 1, 1, dp),
                  memo(nums, cap, i + 1, 0, dp));
      }
      return dp[i][buy][cap];
  }
    public int max(int[]nums,int cap,int i,int buy){
        if (i==nums.length||cap==0)return 0;
        if (buy==1){
            return Math.max(-nums[i]+max(nums, cap, i+1, 0),
                    max(nums, cap, i+1, 1));
        }
        return Math.max(nums[i]+max(nums, cap-1, i+1, 1),
                max(nums, cap, i+1, 0));
    }
}