package DynamicProgramming.Array;

class CoinChange1 {
    public static void main(String[] args) {

    }
    public int tabulation(int[] nums, int T) {
        int n= nums.length;

        int[][] dp=new int[n][T+1];
        for(int i=0;i<=T;i++){
            dp[0][i]=i%nums[0]==0?i/nums[0]:(int)Math.pow(10,9);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=T;j++){
                int ntake=dp[i-1][j];
                int take=(int)Math.pow(10,9);
                if(nums[i]<=j)take=1+dp[i][j-nums[i]];
                dp[i][j]=Math.min(take,ntake);
            }
        }
        int ans= dp[n-1][T];
        return ans>=(int)Math.pow(10,9)?-1:ans;
    }
    public int coinChange(int[] nums, int target) {
        return find(nums,target,nums.length-1);
    }
    int memo(int[] arr, int ind, int T, int[][] dp){

        if(ind == 0){
            if(T%arr[0] == 0) return T/arr[0];
            else return (int)Math.pow(10,9);
        }

        if(dp[ind][T]!=-1)
            return dp[ind][T];

        int notTaken = memo(arr,ind-1,T,dp);

        int taken = (int)Math.pow(10,9);
        if(arr[ind] <= T)
            taken = 1 + memo(arr,ind,T-arr[ind],dp);

        return dp[ind][T] = Math.min(notTaken,taken);
    }
    private int find(int[]nums,int target,int i){
      
       if (i==0){
           if (target%nums[i]==0)return target/nums[i];
           return (int)1e9;
       }
       int npick=find(nums, target, i-1);
       int pick=Integer.MAX_VALUE;
       if(nums[i]<=target)pick=find(nums, target-nums[i], i);
       return Math.min(npick,pick);
    }
}