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
        System.out.println(tab(nums,tar));
    }

    private static int tab(int[] nums, int target) {
        int[][]dp=new int[nums.length][target+1];
        for (int i = 0; i <=target ; i++) {
            if (target%nums[0]==0){
                dp[0][i]=target/nums[0];
            }else {
                dp[0][i]=Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <=target ; j++) {
                int not_take=dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if (nums[i]<=j){
                    take=dp[i][j-nums[i]];
                }
                dp[i][j]=Math.min(take,not_take);
            }
        }
        return dp[nums.length-1][target]>=1e9?-1:dp[nums.length-1][target];
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
            }
            dp[i][target] = Math.min(take, not_take);
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
