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
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        dp2[0] = 0;
        dp2[1] = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp2[i+1] = Math.max(dp2[i], dp2[i-1]+nums[i]);
        }
        return dp2[nums.length];
    }
    
    private int dpTabulationSpaceOptimized(int[] nums) { //TC --> O(N) || SC--> O(1)
        if(nums.length == 1) return nums[0];
        int a = 0, b = nums[0], c = 0;
        for(int i=1; i<nums.length; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
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