package ArrayProblems.SlidingWindow;

class MaxContinousOnes {
    public static void main(String[] args) {
int[]nums={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums,2));

    }
    public static int longestOnes(int[] nums, int k) {
       int left=0,right=0,maxLength=0,count_zeros=0;
       while (right<nums.length){
           if (nums[right]==0){
               count_zeros++;
           }
           while (count_zeros>k){
               if (nums[left]==0)
                   count_zeros--;
                   left++;
               }
           maxLength=Math.max(maxLength,right-left+1);
           right++;
           }
       return maxLength;
       }
    }
