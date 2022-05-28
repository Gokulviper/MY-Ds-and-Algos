package DynamicProgramming.String;

import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        List<String>ans=new ArrayList<>();
        printAllSubsequence("","abc",ans,2);
        int n=6;
        int i=7;
        System.out.println(i%n);
        System.out.println(tabulationPrintTheString("abcde","bdgek"));
     //   System.out.println(ans);
      //  System.out.println(space("abcde","ace"));
    }
    private static int space(String s1, String s2) {
        int n=s1.length(),m=s2.length();
int []prev=new int[m+1],cur=new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))cur[j]=1+prev[j-1];
                else cur[j]=Math.max(prev[j],cur[j-1]);
            }
            prev=cur.clone();
        }
        return prev[m];
    }
    private static int tabulationPrintTheString(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][]dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i=n;
        int j=m;
        StringBuilder sb=new StringBuilder();
        while (i>0&&j>0){
            if (s1.charAt(i-1)==s2.charAt(j-1)){
                sb.insert(0,s1.charAt(i-1));
                i--;j--;
            }else if(s1.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }else j--;
        }
        System.out.println(sb.toString());
      //  for(int k=1; k<=len;k++){
        //    str +="$"; // dummy string
      //  }
    /*    StringBuilder ss= new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);*/
        return dp[n][m];
    }

    private static int tabulation(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][]dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
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
