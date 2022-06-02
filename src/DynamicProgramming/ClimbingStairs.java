package DynamicProgramming;
// how to indentified this dp probelm
//1)count total number of ways
//  2)multiways to solve which is min or max
//try to  represent the problem to the index
//do all posible stuff in the index accordind to  the problem statement
///ques says
//sum of all of stuff -> sum of all calls
//min of all ->min of alll stuff
public class ClimbingStairs {
    public static void main(String[] args) {
        int n=2;
        System.out.println(topDown(2,new int[n+1]));;
    }
    public int tabulation(int n) {
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];

        }
        return dp[n];
    }

    private static int topDown(int n,int[]dp) {
        if(dp[n]==0){
            if (n==1||n==0){
                dp[n]=1;
            }else{
                dp[n]=topDown(n-1,dp)+topDown(n-2,dp);
            }
        }
        return dp[n];
    }

    private static int climbingWays(int n) {
        if (n==1||n==0)return 1;
        int count=0;
     count=count+climbingWays(n-1);
        count=count+climbingWays(n-2);
        return count;
    }

}
