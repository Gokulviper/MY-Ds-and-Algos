package ArrayProblems.Greedy;

class JumpGame1 {
    public static void main(String[] args) {
        int[]nums={2,3,1,1,4};
        boolean ans=f(nums,1,0);
        System.out.println(ans);

    }

    private static boolean f(int[] nums, int i,int max) {
        if (i>=nums.length-1)return true;
        if (i!=1){
            max=Math.max(max,i+nums[i]);
            return max <i+1?false:true;
        }
         return     f(nums, i+nums[i], max);
    }

    public static boolean canJump(int[] nums) {
      int max=0;
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,i+nums[i]);
            if(max<i+1){
                return false;
            }else if(i>=nums.length-1){
                return true;
            }
        }
        return true;
    }
}