package DynamicProgramming.SubSequence;

import java.util.ArrayList;
import java.util.Arrays;

class TargetSum {
    public static void main(String[] args) {

    }
    public int findTargetSumWays(int[] nums, int target) {
        return tabluationChecl( target, nums);
    }

    private int tabluationChecl(int target, int[] nums) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum-target<0||(sum-target)%2==1)return 0;
        return spaceOprtimized((sum-target)/2,nums);
    }

    private int spaceOprtimized(int tar, int[] num) {
        int n = num.length;

        int prev[]=new int[tar+1];

        if(num[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
        else prev[0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            int cur[]=new int[tar+1];
            for(int target= 0; target<=tar; target++){
                int notTaken = prev[target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];

                cur[target]= (notTaken + taken);
            }
            prev = cur;
        }
        return prev[tar];
    }

    private int tabluation(int target, int[] nums) {
        int[][]dp=new int[nums.length][target+1];
      dp[0][0]=nums[0]==0?2:1;
      if (nums[0]!=0&&nums[0]<=target)dp[0][nums[0]]=1;
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <=target ; j++) {
                 int not_pick=dp[i-1][j];
                 int pick=0;
                 if(nums[i]<=j){
                     pick=dp[i-1][j-nums[i]];
                 }
                 dp[i][j]=pick+not_pick;
            }
        }
        return dp[nums.length-1][target];
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
        if(nums[index]<=target){
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