package ArrayProblems.SlidingWindow;

class MaxContinousOnes {
    public static void main(String[] args) {
int[]nums={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums,2));

    }
    public static int longestOnes(int[] nums, int k) {
        int left=0,right=0;
        while (right<nums.length){
            if(nums[right]==0)k--;
            if (k<0){
                if (nums[left]==0){
                    k++;
                }
                left++;
            }
            right++;
        }
        return right-left;
    }
}