package DynamicProgramming.Array.JumpGame;

import java.util.Arrays;

class JumpGame2 {
    public int jump(int[] nums) {
        int jump=0,farthest=0,end=0;
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(i==end){
                end=farthest;
                jump++;
            }
        }
        return jump;
    }
    int Recursive(int index, int[]nums, int[]dp){
        if(index>=nums.length-1){
            return 0;
        }
        if(dp[index]==-1){
        int min=Integer.MAX_VALUE/10;
        int step=nums[index];
        for(int i=step+index;i>=Math.max(0,index+1);i--){
            min=Math.min(min,1+ Recursive(i,nums,dp));
        }
        dp[index]= min;
        }
        return dp[index];
    }
}