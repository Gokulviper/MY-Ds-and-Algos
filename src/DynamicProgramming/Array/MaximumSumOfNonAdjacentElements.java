package DynamicProgramming.Array;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
     int[]nums={2,3,4,7,8};
        System.out.println( spaceOptimization(nums));
    }

    private static int spaceOptimization(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        for (int i = 1; i < nums.length ; i++) {
    int pick=nums[i];
    if (i>1){
        pick+=prev2;
    }
    int notPick=prev;
    int curr=Math.max(pick,notPick);
    prev2=prev;
    prev=curr;
        }
        return prev;
    }

    private static int bottomUp(int[] nums) {
        int[]dp=new int[nums.length];
        dp[0]=0;
        for (int j = 1; j < nums.length ; j++) {
            int pick=nums[j];
            if (j>1){
                pick+=dp[j-2];
            }
            int notPick=dp[j-1];
            dp[j]=Math.max(pick,notPick);
        }
        return dp[nums.length-1];

    }

    private static int maximumTopDown(int[] nums, int i,int[]dp) {
        if (dp[i]==0){
            if (i==0){
                return nums[i];
            } int pick=Integer.MIN_VALUE;
            if (i>1) {
               pick = nums[i] + maximumTopDown(nums, i - 2, dp);
            }
            int notPick= maximumTopDown(nums, i - 1, dp);
            dp[i]=Math.max(pick,notPick);
        }
        return dp[i];
    }

    private static int maximum(int[] nums, int i) {
        if (i==0){
            return nums[i];
        }
        if (i<0){
            return 0;
        }
        //i-2 beacuse we dont pick the adjacnet elements
        int pick=nums[i]+maximum(nums,i-2);
        int notPick= maximum(nums, i - 1);
        return Math.max(pick,notPick);
    }
}
