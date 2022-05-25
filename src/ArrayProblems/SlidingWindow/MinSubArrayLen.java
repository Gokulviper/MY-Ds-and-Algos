package ArrayProblems.SlidingWindow;

class MinSubArrayLen {
    public static void main(String[] args) {

        int[]nums={1,4,4};
      int  target = 4;
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,current_sum=0;
        int min=Integer.MAX_VALUE;
       for (;right<nums.length;right++){
            current_sum+=nums[right];
            while (current_sum>=target){
                min=Math.min(min,right-left+1);
                current_sum-=nums[left++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}