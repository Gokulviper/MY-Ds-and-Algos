package DynamicProgramming.String.matching;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s="horse",t="ros";
        int[][]dp=new int[s.length()+1][t.length()+1];
        for(int[]row:dp) Arrays.fill(row,-1);
         memo(s,t,s.length()-1,t.length()-1,dp);
    }
    int tabulation(String s,String t){
        int n=s.length(),m=t.length();
        int[][]dp=new int[n+1][m+1];
        //base case
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=m ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
              if (s.charAt(i-1)==t.charAt(j-1)){
                  dp[i][j]=dp[i-1][j-1];
              }else{
                  dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
              }
            }
        }
        return dp[n][m];
    }


   static int memo(String s, String t, int i, int j, int[][]dp){
     //this case is s is exhausted the range -1 but t have  2 elements so you need insert this 2 elements
        if (i<0)return j+1;
       //this case is t is exhausted the range -1 but  s have  2 elements so you need delete this 2 elements
        if (j<0)return i+1;
        if(dp[i][j]==-1){
            if(s.charAt(i)==t.charAt(j)){
                dp[i][j]= memo(s, t, i-1, j-1,dp);
            }else
                dp[i][j]= Math.min(Math.min(1+ memo(s, t, i-1, j,dp),1+ memo(s, t, i, j-1,dp)),1+ memo(s, t, i-1, j-1,dp));
        }
        return dp[i][j];
    }
    int memo(String s, String t, int i, int j){
        if (i<0)return j+1;
        if (j<0)return i+1;
        if(s.charAt(i)==t.charAt(j)){
            return memo(s, t, i-1, j-1);
        }
        return Math.min(Math.min(1+ memo(s, t, i-1, j),1+ memo(s, t, i, j-1)),1+ memo(s, t, i-1, j-1));
    }
}
