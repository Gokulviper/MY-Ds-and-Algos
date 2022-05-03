package DynamicProgramming;

public class Fibonacci {
    public static void main(String[] args) {
        int n=50;
        System.out.println(spaceOptmized(n));
    }

    private static int NoramRecursion(int n) {
        if (n<=1){
            return n;
        }
        return NoramRecursion(n-1)+NoramRecursion(n-2);
    }

    private static int spaceOptmized(int n) {
        int prev=1;
        int s_prev=0;
        int f=0;
        for (int i = 2; i <n+1 ; i++) {
            f=prev+s_prev;

            s_prev=prev;
            prev=f;
        }
        return f;
    }

    private static int topDown(int n, int[] dp) {
     if (dp[n]==0){
         if (n<2){
             dp[n]=n;
         }else {
             dp[n]=topDown(n-1,dp)+topDown(n-2,dp);
         }
     }
return dp[n];
    }

    private static int bottomUp(int n) {
        int dp[]=new int[n+1];
        dp[0]=0;dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

}
