package DynamicProgramming.BuyandSellStocks;

public class BuyAndSellStocks1 {
    public int maxProfit(int[] nums) {
        int min=Integer.MAX_VALUE,max_profit=Integer.MAX_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
            max_profit=Math.max(max_profit,num-min);
        }
        return max_profit;
    }
}
