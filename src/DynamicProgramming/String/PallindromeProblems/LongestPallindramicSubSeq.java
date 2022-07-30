package DynamicProgramming.String.PallindromeProblems;

class LongestPallindramicSubSeq {
    //you know how to get the longest subseq
    //pallindrome is same to reverse the string send same method os lcs
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        String rev=sb.reverse().toString();
        return lcs(s,rev);
    }
    private int lcs(String s1,String s2){
        int n=s1.length();
        int[][]dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                 dp[i][j]=1+dp[i-1][j-1];   
                }else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}