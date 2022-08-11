package DynamicProgramming.String;

import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        List<String>ans=new ArrayList<>();
      tabulation("abcde","ace");

    }
    private static String space(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][]dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=n,j=m;
        while(i>0&&j>0){

            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.insert(0,s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.insert(0,s1.charAt(i-1));
                i--;
            }else{
                sb.insert(0,s2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            sb.insert(0,s1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.insert(0,s2.charAt(j-1));
            j--;
        }
        return sb.toString();
    }

    private static int tabulation(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][]dp=new int[n+1][m+1];
        int i=1,j=1;
        for( i=1;i<=n;i++){
            for( j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][]dp=new int[text1.length()][text2.length()];
        for (int[]row:dp){
            Arrays.fill(row,-1);
        }
              return memo(text1,text2,text1.length()-1,text2.length()-1,dp);
    }

    private static int memo(String s1, String s2, int i, int j, int[][] dp) {
        if (i<0||j<0)return 0;
        if (dp[i][j]==-1){
            if (s1.charAt(i)==s2.charAt(j)){
             dp[i][j]=1+memo(s1, s2, i-1, j-1, dp);
            }else
            {
                dp[i][j]=Math.max(memo(s1, s2, i-1, j, dp),memo(s1, s2, i, j-1, dp));
            }
        }
        return dp[i][j];
    }

    private static int findall(String s1, String s2, int i, int j) {
        if (i<0||j<0)return 0;
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+findall(s1, s2, i-1, j-1);
        }
        return Math.max(findall(s1, s2, i-1, j),findall(s1, s2, i, j-1));
    }

    private static void printAllSubsequence(String p, String s, List<String> ans,int n) {
   if(s.isEmpty()) {
       if(!p.isEmpty()) {
           ans.add(p);
       }
       return;
   }
      printAllSubsequence(p,s.substring(1),ans,n);
      printAllSubsequence(p+s.charAt(0),s.substring(1),ans,n);
    }
}
