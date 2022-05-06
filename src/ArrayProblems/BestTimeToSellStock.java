package ArrayProblems;

public class BestTimeToSellStock {
    public static void main(String[] args) {

    }
    public static int maxProfit(int[]nums){
        int min=Integer.MAX_VALUE;
        int max_profit=0;
        for (int i = 0; i < nums.length; i++) {
            min=Math.min(min,nums[i]);
            max_profit=Math.max(nums[i]-min,max_profit );
        }
        return max_profit;
    }
}
