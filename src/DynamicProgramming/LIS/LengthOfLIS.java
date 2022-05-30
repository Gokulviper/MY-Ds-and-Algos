package DynamicProgramming.LIS;

class LengthOfLIS {
    public static void main(String[] args) {

    }
    public int tabulation(int[] nums) {
        int[][]dp=new int[nums.length+1][nums.length+1];

        for(int i=nums.length-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){

                int not_take=dp[ i+1][ prev+1];
                int take=0;
                if(prev==-1||nums[i]>nums[prev]){
                    take=1+dp[ i+1][ i+1];
                }
                dp[i][prev+1]= Math.max(take,not_take);
            }
        }

        return dp[0][0];
    }
    public int memo(int[] nums, int i, int prev, int[][]dp) {
        if (i == nums.length) return 0;
        if (dp[i][prev + 1] == -1) {
            int not_take = memo(nums, i + 1, prev, dp);
            int take = 0;
            if (prev == -1 || nums[i] > nums[prev]) {
                take = 1 + memo(nums, i + 1, i, dp);
            }
            dp[i][prev + 1] = Math.max(take, not_take);
        }
        return dp[i][prev + 1];
    }
    public int lengthOfLIS(int[] nums,int i,int prev) {
        if (i==nums.length)return 0;
        int not_take=lengthOfLIS(nums, i+1, prev);
        int take=0;
        if(prev==-1||nums[i]>nums[prev]){
            take=lengthOfLIS(nums, i+1, i);
        }
        return Math.max(take,not_take);
    }
}