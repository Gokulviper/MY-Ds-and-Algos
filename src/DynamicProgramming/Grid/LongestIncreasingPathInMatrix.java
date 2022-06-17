package DynamicProgramming.Grid;

import java.util.*;

class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {

    }
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][]dp=new int[n][m];
        for (int r[]:dp) Arrays.fill(r,-1);
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max=Math.max(dfs(matrix,dp,i,j,-1),max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] dp, int row, int col, int prev) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix.length || matrix[row][col] <= prev) {
            return 0;
        }
        if (dp[row][col] == -1) {

            dp[row][col]= 1 + Math.max(Math.max(Math.max(dfs(matrix, dp, row + 1, col, matrix[row][col]), dfs(matrix, dp, row, col + 1, matrix[row][col]))
                    , dfs(matrix, dp, row, col - 1, matrix[row][col])), dfs(matrix, dp, row - 1, col, matrix[row][col]));
        }
        return dp[row][col];
    }
}