package DynamicProgramming.Array;

import java.util.Arrays;

public class FindMinimumCoins {
    public static void main(String[] args) {
int[]nums={1,2,3};
int tar=8;
int[][]dp=new int[nums.length][tar+1];
for (int[]row:dp){
    Arrays.fill(row,-1);
}
        System.out.println(memo(nums,tar,nums.length-1,dp));
    }

    private static int memo(int[] nums, int target, int i, int[][] dp) {
        if (i == 0) {
            if (target % nums[0] == 0) return target / nums[0];
            else return (int) 1e9;
        }
        if (dp[i][target] == -1) {


            int not_take = memo(nums, target, i - 1, dp);
            int take = Integer.MAX_VALUE;
            if (nums[i] <= target) {
                take = 1 + memo(nums, target - nums[i], i, dp);

                dp[i][target] = Math.min(take, not_take);
            }


        }        return dp[i][target];
    }

    private static int find(int[]nums,int target,int i){
        if (i==0){
            if (target%nums[0]==0)return target/nums[0];
            else return (int)1e9;
        }
        int not_take=find(nums,target,i-1);
        int take=Integer.MAX_VALUE;
        if (nums[i]<=target){
            take=1+find(nums, target-nums[i], i);
        }
        return Math.min(take,not_take);
    }
}
