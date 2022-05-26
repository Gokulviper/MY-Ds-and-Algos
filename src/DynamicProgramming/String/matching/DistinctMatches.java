package DynamicProgramming.String.matching;

public class DistinctMatches {
    public static void main(String[] args) {

    }
    private int tabulation(String s1,String s2){
        int n=s1.length(),m=s2.length();
        int[][]dp=new int[n+1][m+1];//changed tp 1 based indexing
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][m];

    }

    private int memo(String s1,String s2,int i,int j,int[][]dp){
        if (j<0)return 1;//we find the string
        if (i<0)return 0;//we not find the string
        int count=0;
        if (dp[i][j]==-1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                count = count + memo(s1, s2, i - 1, j - 1, dp) + memo(s1, s2, i - 1, j, dp);
            } else
                count = count + memo(s1, s2, i - 1, j, dp);

            dp[i][j]= count;
        }
        return dp[i][j];
    }
    private int findAllMatches(String s1,String s2,int i,int j){
        if (j<0)return 1;//we find the string
        if (i<0)return 0;//we not find the string
        int count=0;
        if (s1.charAt(i)==s2.charAt(j)){
            count=count+findAllMatches(s1, s2, i-1, j-1)+findAllMatches(s1, s2, i-1, j);
        }else
            count=count+findAllMatches(s1, s2, i-1, j);

        return count;
    }
}
