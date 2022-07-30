package DynamicProgramming.String.matching;

class RegularExpression {


    public boolean tabulation(String s, String p) {
        boolean[][]dp=new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()]=true;
        for (int i = s.length(); i >=0; i--) {
            for (int j = p.length()-1; j >=0 ; j--) {
                boolean match= (i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'));
                if(j+1<p.length()&&p.charAt(j+1)=='*'){
                    dp[i][j]=dp[i][j+2]||(match&&dp[i+1][j]);
                }else if(match) {
                  dp[i][j]=dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()];
        return dfs(s, p, dp, 0, 0);
    }
    boolean dfsRecursion(String s, String p, boolean[][] dp, int i, int j){
        if(i>=s.length()&&j>=p.length())return true;
        if(j>=p.length())return false;

        boolean match= (i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'));
        if(j+1<p.length()&&p.charAt(j+1)=='*'){
            return dfsRecursion(s,p,dp,i,j+2)||(match&&dfsRecursion(s,p,dp,i+1,j));
        }else if(match){
            return dfsRecursion(s,p,dp,i+1,j+1);
        }else{
            return false;
        }

    }
    boolean dfs(String s, String p, Boolean[][] dp, int i, int j){
        // Both i and j have reached the end of the respective strings, then definitely we have found a match
        if(i >= s.length() && j >= p.length())
            return true;
        // If we have reached the end of p, but we haven't reached end of s, then we have a mismatch
        // The vice-versa is however not always true.
        if(j >= p.length())
            return false;
        if(dp[i][j] == null){
            boolean isMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            // If the next char (j+1)th in p is a *, then we have 2 options -
//  1. Ignore the jth char and compare ith char with (j+2)th char as j+1 is '*'
            //  2. Match the 2 chars in i & j of s an p respectively and then
            //     consider the same jth char for comparison with the next char of i
            if(j+1 < p.length() && p.charAt(j+1) == '*')
                dp[i][j] = dfs(s, p, dp, i, j+2) || // When jth char in p is ignored
                        (isMatch && dfs(s, p, dp, i+1, j)); // When jth char is used for comparison with next char of s

                // If the 2 chars in s and p match, then we explore the next 2 chars in both
            else if(isMatch)
                dp[i][j] = dfs(s, p, dp, i+1, j+1);
                // We couldn't find a match
            else
                dp[i][j] = false;
        }
        return dp[i][j];
    }
}
