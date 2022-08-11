package DynamicProgramming.LIS;

import java.util.Arrays;

class FindLongestStringChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b)->a[0]-b[0]);
        int ans=0;
       int[]dp=new int[pairs.length];
        Arrays.fill(dp,1);
        for(int i=0;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        for(int num:dp)
            ans=Math.max(ans,num);
        return ans;
    }
}