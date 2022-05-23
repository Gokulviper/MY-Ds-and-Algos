package DynamicProgramming.String;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(lcs("abefd", "gfabeg"));
    }
        static int lcs(String s1, String s2){
int n=s1.length();
int m=s2.length();
int[][]dp=new int[n+1][m+1];
int ans=0;
            for (int i = 1; i <=n ; i++) {
                for (int j = 1; j <=m ; j++) {
                    if (s1.charAt(i-1)==s2.charAt(j-1)){
                        int val=1+dp[i-1][j-1];
                        dp[i][j]=val;
                        ans=Math.max(ans,val);
                    }else{
                        dp[i][j]=0;
                    }
                }
            }
            return ans;
   //
    }
    static int lcsSpaceOptimization(String s1, String s2){

        int n = s1.length();
        int m = s2.length();

   ///      int[][] dp=new int[n+1][m+1];
        int prev[]=new int[m+1];
        int cur[]=new int[m+1];

        int ans = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    int val = 1 + prev[j-1];
                    cur[j] = val;
                    ans = Math.max(ans,val);
                }
                else
                    cur[j] = 0;
            }
            prev=cur;
        }

        return ans;
    }
}
