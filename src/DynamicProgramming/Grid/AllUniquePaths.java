package DynamicProgramming.Grid;

import java.util.Arrays;
//if the alorithm we use the previuos row and previous col we can optimze the space
public class AllUniquePaths {
    public static void main(String[] args) {
        int[][]dp=new int[4][4];
        for (int[]row:dp) {
            Arrays.fill(row,-1);
        }
   System.out.println(memorization(3,3,dp));
        System.out.println(tabulation(4,4));
        System.out.println(allPaths(2,6));
    }
    public int uniquePaths(int m, int n) {
        int[]prev=new int[n];
        int[]cur=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    cur[j]=1;
                }else{
                    int count=0;
                    if(i>0) count+=prev[j];
                    if(j>0) count+=cur[j-1];
                    cur[j]=count;
                }
            }
            prev=cur;
        }
        return prev[n-1];
    }

    private static int tabulation(int row, int col) {
        int[][]dp=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count=0;
                if (i==0&&j==0){
                    dp[i][j]=1;
                    continue;
                }
                if (i>0){
                    count+=dp[i-1][j];
                }
                if (j>0){
                    count+=dp[i][j-1];
                }
                dp[i][j]=count;
            }
        }
        return dp[row-1][col-1];

    }

    private static int memorization(int row, int col, int[][] dp) {
        if (row==0&&col==0){
            return 1;
        }
        if (row<0||col<0){
            return 0;
        }
        if (dp[row][col]!=-1) {
            return dp[row][col];
        }
            int count = 0;
            count=count+memorization(row-1,col,dp);
            count=count+memorization(row,col-1,dp);
            dp[row][col]=count;

        return dp[row][col];
    }

    private static int allPaths(int row, int col) {
        if (row==0&&col==0){
            return 1;
        }
        if (row<0||col<0){
            return 0;
        }
        int count=0;
        count=count+allPaths(row-1,col);
        count=count+allPaths(row,col-1);
        return count;
    }
}
