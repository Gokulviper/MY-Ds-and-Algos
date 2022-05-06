package DynamicProgramming.Array;

import java.util.Arrays;

class HouseRobber {
    
    private int dpMemoization(int[] nums, int index, int[] dp1) { //TC --> O(N) || SC--> O(N)
        if(index < 0) return 0;
        if(index == 0) return nums[0];
        
        if(dp1[index] == -1) {
            int robbed = nums[index] + dpMemoization(nums, index-2, dp1);
            int notRobbed = dpMemoization(nums, index-1, dp1);
            dp1[index] =  Math.max(robbed, notRobbed);
        }
        return dp1[index];
    }
    
    private int dpTabulation(int[] nums, int[] dp2) { //TC --> O(N) || SC--> O(N)
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
    
    private int dpTabulationSpaceOptimized(int[] nums) { //TC --> O(N) || SC--> O(1)
        if(nums.length == 1){
            return nums[0];
        }
        int s_prev=0,prev=nums[0],currentSum=0;
        for(int i=1;i<nums.length;i++){
            currentSum=Math.max(s_prev+nums[i],prev);
            s_prev=prev;
            prev=currentSum;
        }
        return currentSum;
    }
    
    public int rob(int[] nums) {
        //Dp with memoization
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        return dpMemoization(nums, nums.length-1, dp1);
        
        //Dp with tabulation using extra space
        //int[] dp2 = new int[nums.length+1];
      //  return dpTabulation(nums, dp2);
        
        //Dp with tabulation without using extra space (2 variables)
      //  return dpTabulationSpaceOptimized(nums);
    }
}