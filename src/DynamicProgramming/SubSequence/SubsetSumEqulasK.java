package DynamicProgramming.SubSequence;

import java.util.Arrays;

public class SubsetSumEqulasK {
    public static void main(String[] args) {
        int[]nums={3,5,6,7};
        int k=34;
        int[][]dp=new int[nums.length][k+1];
        for (int[]row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(Tabulation(nums.length,k,nums));
    }
    static boolean Tabulation(int n, int k,int[] arr){


        boolean dp[][]= new boolean[n][k+1];
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0]<=k)
            dp[0][arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }

        return dp[n-1][k];
    }



    private static boolean memoriazation(int ind, int target,int[] arr, int[][] dp) {
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target] != 0;

        boolean notTaken = memoriazation(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = memoriazation(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }

    private static boolean f(int[] nums, int index, int target) {
        if (target==0){
            return true;
        }
        if (index==0){
            return nums[index]==target;
        }
        boolean not_take=f(nums,index-1,target);
        boolean take=false;
        if (nums[index]<=target){
            take=f(nums,index-1,target-nums[index]);
        }
        return take||not_take;
    }

}
