package DynamicProgramming.Grid;

import java.util.Arrays;

public class AllUniquePaths {
    public static void main(String[] args) {
        int[][]dp=new int[4][4];
        for (int[]row:dp) {
            Arrays.fill(row,-1);
        }
   System.out.println(memorization(3,3,dp));
        System.out.println(allPaths(3,3));
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
