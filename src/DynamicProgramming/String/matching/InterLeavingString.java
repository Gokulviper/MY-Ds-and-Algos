package DynamicProgramming.String.matching;

import java.util.Arrays;

public class InterLeavingString {
    public static void main(String[] args) {
    }

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            int[][]dp=new int[s1.length()][s2.length()];
            for (int []r:dp) Arrays.fill(r,-1);
            return find(s1,s2,s3,0,0,0,dp);

        }
    public boolean space(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean prev[]=new boolean[s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                  prev[j] = true;
                } else if (i == 0) {
                    prev[j] = prev[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    prev[j] = prev[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    prev[j] = (prev[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (prev[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return prev[s2.length()];

    }
    static boolean tabulation(String s1,String s2,String s3){
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }
        static boolean find(String s1,String s2,String s3,int i,int j ,int k,int[][]dp){
            //if s1 is exhausted so balance s2 Strings are match with balance s3 string
            if (i==0){
                return s2.substring(j).equals(s3.substring(k));
            }
            //if s2 is exhausted so balance s1 Strings are match with balance s3 string
            if (j==0){
                return s1.substring(i).equals(s3.substring(k));
            }
            if (dp[i][j]==-1) {
                boolean ans = false;
      if ((s1.charAt(i) == s3.charAt(k) && find(s1, s2, s3, i -1, j, k - 1, dp)) || (s2.charAt(j) == s3.charAt(k) && find(s1, s2, s3, i, j - 1, k - 1, dp))) {
                    ans = true;
                }
                dp[i][j]= ans?1:0;
            }
            return    dp[i][j]==1;
        }
}
