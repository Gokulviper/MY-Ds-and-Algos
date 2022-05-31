package DynamicProgramming.LIS;
//go binary search package for optimized approach
import java.util.Arrays;

class LengthOfLIS {
    public static void main(String[] args) {

    }
    public int singleArraySpace(int[] nums) {
       int[]dp=new int[nums.length];
        Arrays.fill(dp,1);//beacuse the lowest increasing subseqence length is 1
int max=0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            max=Math.max(max,dp[i]);}
        return max;
    }

    public int space(int[] nums) {
        int[]prev_row=new int[nums.length],cur_row=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            //prev index is previous of curent so you take  is 1 based indexing
            //you avoid is condition is -1 so you put +1 it could be zero
            for(int prev=i-1;prev>=-1;prev--){
                int not_take=prev_row[ prev+1];
                int take=0;
                if(prev==-1||nums[i]>nums[prev]){
                    take=1+prev_row[ i+1];
                }
                cur_row[prev+1]= Math.max(take,not_take);
            }
            prev_row=cur_row;
        }

        return cur_row[0];
    }
    public int tabulation(int[] nums) {
        int[][]dp=new int[nums.length+1][nums.length+1];

        for(int i=nums.length-1;i>=0;i--){
            //prev index is previous of curent so you take  is 1 based indexing
            //you avoid is condition is -1 so you put +1 it could be zero
            for(int prev=i-1;prev>=-1;prev--){
                int not_take=dp[ i+1][ prev+1];
                int take=0;
                if(prev==-1||nums[i]>nums[prev]){
                    take=1+dp[ i+1][ i+1];
                }
                dp[i][prev+1]= Math.max(take,not_take);
            }
        }

        return dp[0][0];
    }
    public int memo(int[] nums, int i, int prev, int[][]dp) {
        if (i == nums.length) return 0;
        if (dp[i][prev + 1] == -1) {
            int not_take = memo(nums, i + 1, prev, dp);
            int take = 0;
            if (prev == -1 || nums[i] > nums[prev]) {
                take = 1 + memo(nums, i + 1, i, dp);
            }
            dp[i][prev + 1] = Math.max(take, not_take);
        }
        return dp[i][prev + 1];
    }
    public int lengthOfLIS(int[] nums,int i,int prev) {
        if (i==nums.length)return 0;
        int not_take=lengthOfLIS(nums, i+1, prev);
        int take=0;
        if(prev==-1||nums[i]>nums[prev]){
            take=lengthOfLIS(nums, i+1, i);
        }
        return Math.max(take,not_take);
    }
}