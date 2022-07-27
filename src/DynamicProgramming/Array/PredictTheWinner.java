package DynamicProgramming.Array;

public class PredictTheWinner {
    public static void main(String[] args) {
        int[]nums={1,5,2};
        System.out.println(   PredictTheWinner(nums));
    }


    public boolean PredictTheWinner1(int[] nums) {
        int[][]dp=new int[nums.length][nums.length];
        for (int s = nums.length; s >=0 ; s--) {
            for (int e = s; e <nums.length ; e++) {
                if (s==e){
                    dp[s][e]=nums[e];
                }else{
                    int a=nums[s]-dp[s+1][e];
                    int b=nums[e]-dp[s][e-1];
                    dp[s][e]=Math.max(a,b);
                }
            }
        }
       return dp[0][nums.length-1]>=0;
    }
    public static boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }
    public static int winner(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
      //  if (memo[s][e] != null)
      //      return memo[s][e];
        int a = nums[s] - winner(nums, s + 1, e, memo);
        int b = nums[e] - winner(nums, s, e - 1, memo);
     //   memo[s][e] = Math.max(a, b);
     //   return memo[s][e];
        return Math.max(a,b);
    }
} 