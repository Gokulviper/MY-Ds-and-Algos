package DynamicProgramming.String;

class MinimumInsertionMakePallindrome {
    //the idea which string is not pallindrome in the string so
    // the step which is not pallindrome we take the all charecters puth again the stirng that makes a pallidrome
    //so the lcs tell the which the longest pallindrmic subsequnece tells the wich is the greatest subsequence
    //so we subract the length by the longest pallindrmic subseq
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
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
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                
            }
        }
        return dp[n][n];
    }
}