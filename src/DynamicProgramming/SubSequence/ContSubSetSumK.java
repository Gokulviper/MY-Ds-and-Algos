package DynamicProgramming.SubSequence;

import java.util.Arrays;
import java.util.HashMap;

public class ContSubSetSumK {
    public static void main(String[] args) {
        int[]nums={1,1,1};
        int[][]dp=new int[nums.length][4];
        for (int[]row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(tabulation(nums,3));
    }

    private static int tabulation(int[] nums,int target) {
        int[][]dp=new int[nums.length][target+1];
        for (int i = 0; i <nums.length ; i++) {
            dp[i][0]=1;
        }
        if (nums[0]<=target)dp[0][nums[0]]=1;
        for (int index = 1; index < nums.length ; index++) {
            for (int sum = 0; sum <= target; sum++) {
               int count=0;
               count+=dp[index-1][sum];
               if (nums[index]<=sum)count+=dp[index-1][sum-nums[index]];
               dp[index][sum]=count;
            }
        }
        return dp[nums.length-1][target];
    }

    private static int memo(int[] nums, int index, int target, int[][] dp) {
        if (target==0){
            return 1;
        }
        if (index==0){
            if (nums[index]==target){
                return 1;
            }
            return 0;
        }
        if (dp[index][target]==-1){
           int count=0;
           count=count+memo(nums,index-1,target,dp);
           if (nums[index]<=target){
               count=count+memo(nums, index-1, target-nums[index], dp);
           }
           dp[index][target]=count;
        }
        return dp[index][target];
    }

    private static int countSubsets(int[] nums, int index, int target) {
        if (target==0){
            return 1;
        }
        if (index==0){
            if (nums[index]==target) {
                return 1;
            }
            return 0;
        }
        int count=0;
        count=count+countSubsets(nums,index-1,target);
        if (nums[index]<=target){
            count=count+countSubsets(nums,index-1,target-nums[index]);
        }
        return count;
    }
    public int subarraySum(int[] nums, int target) {
        //this for handle both +ve and -ve numbers

        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap();
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-target)){
                count+=map.get(sum-target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
