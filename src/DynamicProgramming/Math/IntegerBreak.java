package DynamicProgramming.Math;

class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max( dp[i], Math.max(dp[i-j], i-j) * j);
            }
        }
        return dp[n];
    }
    public int integerBreak1(int n) {
        //
         if(n == 2){
            return 1;
        }else if(n == 3){
            return 2;
        }
        int ans = 1;
        while(n > 4){
            ans *= 3;
            n -= 3;
        }
        return ans*n;
    }
}