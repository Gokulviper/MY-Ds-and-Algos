package DynamicProgramming.Array;

import java.util.ArrayList;
import java.util.Arrays;

class TargetSum {
    public static void main(String[] args) {

    }
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums.length, target, nums);
    }

    private int targetSum(int n, int target, int[] nums) {
        int sum=0;
        for (int num:nums) {
            sum+=num;
        }
        if(sum-target<0||sum-target%2==1)return 0;
        int s2=(sum-target)/2;
        return find(n-1,s2,nums);
    }

    private int find(int index, int target, int[] nums) {
        if (index==0){
            if (target==0&&nums[0]==0)return 2;
            if (target==0||target==nums[0])return 1;
            return 0;
        }
        int not_pick=find(index-1,target,nums);
        int pick=0;
        if(nums[0]<=target){
            pick=find(index-1,target-nums[index],nums);
        }
        return pick+not_pick;
    }

    private int targetSumMem0(int n, int target, int[] nums) {

        int totalSum=0;
        for (int num:nums){
            totalSum+=num;
        }

        if (totalSum-target<0||(totalSum-target)%2==1)return 0;
    int s2=(totalSum-target)/2;
        int[][]dp=new int[nums.length][s2+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return memo(n-1,s2,nums,dp);
    }

    private int memo(int index, int target, int[] nums, int[][] dp) {
        if (index==0){
            if (target==0&&nums[0]==0){
                return 2;
            }if (target==0||target==nums[0])return 1;
            return 0;
        }
        if(dp[index][target]==-1){
             int not_taken=memo(index-1, target, nums, dp);
             int take=0;
             if (nums[index]<=target){
                 take=memo(index-1, target-nums[index], nums, dp);
             }
             dp[index][target]=take+not_taken;
        }
        return dp[index][target];
    }
}