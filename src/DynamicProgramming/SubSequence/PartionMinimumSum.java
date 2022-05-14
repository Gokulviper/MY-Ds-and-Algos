package DynamicProgramming.SubSequence;

public class PartionMinimumSum {
    public static void main(String[] args) {

    }
    private int minimumSumDiffernce(int[]nums){
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
       boolean[][]dp=new boolean[nums.length][sum+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0]=true;
        }
        if (nums[0]<=sum){
            dp[0][sum]=true;
        }
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 1; j <=sum ; j++) {
                boolean not_t=dp[i-1][j];
                boolean take=false;
                if (nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=not_t||take;
            }
        }
        int min=(int)1e9;
        for (int i = 0; i <sum ; i++) {
            if (dp[nums.length-1][i]){
                int diff=Math.abs(i-(sum-i));
                min=Math.min(min,diff);
            }
        }
        return min;
    }
}
