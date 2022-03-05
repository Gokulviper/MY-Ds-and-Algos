package ArrayProblems.SlidingWindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[]nums={4,2,1,7,8,1,2,8,1,0};int k=3;

        System.out.println( findMaxSubArray(nums,k));
    }

    private static int findMaxSubArray(int[] nums, int k) {
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            if (i>=(k-1)){
                maxSum=Math.max(maxSum,currentSum);
                currentSum-=nums[i-(k-1)];
            }
        }
        return maxSum;
    }
}
