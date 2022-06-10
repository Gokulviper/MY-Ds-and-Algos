package DynamicProgramming.String.matching;

import java.util.Arrays;

class WildCardMatching {
    public boolean isMatch(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        boolean dp[][] = new boolean[n][m];

        return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
    }
    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }

    static boolean wildcardMatchingUtil(String S1, String S2, int i, int j, boolean[][] dp) {

        //Base Conditions
        if (i < 0 && j < 0)
            return true;
        if (j < 0)
            return false;
        if (i < 0)
            return isAllStars(S2, j) ;

        if (!dp[i][j] ) return dp[i][j];


        if (S1.charAt(i) == S2.charAt(j) || S2.charAt(j) == '?')
            return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

        else {
            if (S2.charAt(j) == '*')
                return (wildcardMatchingUtil(S1, S2, i - 1, j, dp)) || (wildcardMatchingUtil(S1, S2, i, j - 1, dp) );
            else return false;
        }
    }

}