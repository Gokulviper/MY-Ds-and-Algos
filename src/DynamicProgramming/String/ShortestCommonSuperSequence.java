package DynamicProgramming.String;
/*
 first get lcs of both strings because wwe dont twice in both comman characters
 you can use the table traverse from the back of printing method
 //cases
 1: if both are same add one time in ans string decrement both i-- j--
 2: if the i-1 is greater so i-- id you ignore any character just add your string
 3:j-1 is greater j-- add the jj string character
 after finished extra balanced elements in the both strings add the ans string

 */
class ShortestCommonSuperSequence {
    public static void main(String[] args) {

    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][]dp=new int[n+1][m+1] ;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if (str1.charAt(i-1)==str1.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=n,j=m;
        while (i>0&&j>0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while (i-->0)    sb.append(str1.charAt(i - 1));
        while (j-->0)    sb.append(str2.charAt(j - 1));
        return sb.reverse().toString();

    }
}