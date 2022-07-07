package ArrayProblems;

class MaxCircularSubarraySum {
    public int maxSubarraySumCircular(int[] nums) {
     int currentMax=nums[0],currentMin=nums[0];
        int minSum=nums[0],maxSum=nums[0],sum=nums[0];
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(nums[i],currentMax+nums[i]);
            maxSum=Math.max(maxSum,currentMax);
            currentMin=Math.min(nums[i],nums[i]+currentMin);
            minSum=Math.min(minSum,currentMin);
            sum+=nums[i];
            
        }
        return minSum==sum?maxSum:Math.max(maxSum,sum-minSum);
    }
}