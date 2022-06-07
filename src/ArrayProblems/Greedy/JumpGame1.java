package ArrayProblems.Greedy;

class JumpGame1 {
    public boolean canJump(int[] nums) {
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