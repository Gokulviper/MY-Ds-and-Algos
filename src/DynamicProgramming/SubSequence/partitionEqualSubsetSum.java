package DynamicProgramming.SubSequence;

import java.util.Arrays;
//this is same algorithm of subset sum equlas k
//firsr  we divide the total sum is odd return fasle
//send the function same fucnction target is sum/2

class partitionEqualSubsetSum {
    public static void main(String[] args) {
        int[]nums={1,5,11,5};
        System.out.println(tabulation(nums));
    }

    private static boolean tabulation(int[] nums) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2!=0)return false;
        int target=sum/2;
        boolean[][]dp=new boolean[nums.length][target+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0]=true;

        }
        if (nums[0]<=target){
            dp[0][nums[0]]=true;
        }
        for (int index = 1; index <nums.length ; index++) {
            for (int j = 1; j <=target ; j++) {
                boolean not_take=dp[index-1][j];
                boolean take=false;
                if(nums[index]<=j){
                    take=dp[index-1][j-nums[index]];
                }
                dp[index][target]=take||not_take;
            }

        }
        return dp[nums.length-1][target];
    }

    public static boolean canPartition(int[] nums) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2!=0)return false;
        int[][]dp=new int[nums.length][(sum/2)+1];
        for (int[]row:dp){
            Arrays.fill(row,-1);
        }
     return    memo(nums,nums.length-1,sum/2,dp);
    }

    private static boolean memo(int[] nums, int index, int target, int[][] dp) {
        if (target==0){
            return true;
        }
        if (index==0){
            return nums[index]==target;
        }
        if (dp[index][target]!=-1)return dp[index][target]!=0;
        boolean not_take=memo(nums,index-1,target,dp);
        boolean take=false;
        if(nums[index]<=target){
            take=memo(nums,index-1,target-nums[index],dp);
        }
        dp[index][target]=take||not_take?1:0;
        return take||not_take;
    }

    private static boolean check(int[] nums, int index, int target) {
        if (target==0){
            return true;
        }
        if (index==0){
            return nums[index]==target;
        }
        return check(nums,index-1,target)||check(nums,index-1,target-nums[index]);
    }
}