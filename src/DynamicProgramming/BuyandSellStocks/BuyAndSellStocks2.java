package DynamicProgramming.BuyandSellStocks;

class BuyAndSellStocks2 {
    public static void main(String[] args) {

    }
    public  int maxp(int[]nums,int flag,int i){
        if (i==nums.length){
            return 0;
        }
        int profit=0;
        if (flag==0){
            profit=Math.max(-nums[i]+maxp(nums, 0, i+1),maxp(nums,1,i+1));
        }else{
            profit=Math.max(nums[i]+maxp(nums,1,i+1), maxp(nums,0,i+1));
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