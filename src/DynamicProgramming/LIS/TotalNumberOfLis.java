package DynamicProgramming.LIS;

import java.util.Arrays;

class TotalNumberOfLis {
    public int findNumberOfLIS(int[] nums) {
          int[]dp=new int[nums.length];
        int count[]=new int[nums.length];
          Arrays.fill(count,1);
        Arrays.fill(dp,1);//beacuse the lowest increasing subseqence length is 1
int max=1;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j]&&1+dp[j]>dp[i]){
                 dp[i]=dp[j]+1;
                    count[i]=count[j];
                }else if(nums[i]>nums[j]&&1+dp[j]==dp[i]){
                    count[i]+=count[j];
                }
            }
            max=Math.max(max,dp[i]);}
       int ans=0;
      for(int i=0;i<nums.length;i++){
          if(dp[i]==max)ans+=count[i];
        }
        return ans;
    }
}