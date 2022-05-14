package DynamicProgramming.SubSequence;

import java.util.Arrays;

public class SubsetSumEqulasK {
    public static void main(String[] args) {
        int[]nums={3,5,6,7};
        int k=8;
        int[][]dp=new int[nums.length][k+1];
        for (int[]row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(memoriazation(nums.length,k,nums,dp));
    }
    static boolean SpaceOptimization(int n, int k,int[] arr){
        boolean prev[]= new boolean[k+1];
        prev[0] = true;

        if(arr[0]<=k)
            prev[arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = prev[target-arr[ind]];

                cur[target]= notTaken||taken;
            }
            prev=cur;

        }

        return prev[k];
    }
    static boolean Tabulation(int n, int k,int[] arr){
//declare 2d for every row that contain single elemnet make form differnt  cases
        //make all first row first index=0
        //and make the first the arr[0] is less then target mark as true
        //run a nested loop i=1 --> n j=1-->k
        //j is our target check for every index int 2d array


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
