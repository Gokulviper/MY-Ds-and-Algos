package DynamicProgramming.Grid;

import java.util.Arrays;

class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] nums = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(SpaceOptimization(nums));
    }

    private static int SpaceOptimization(int[][] matrix) {

            int m = matrix.length, n = matrix[0].length;
            int result = Integer.MAX_VALUE;

            int[] dp = new int[n];

            //BASE CASE
            for(int i = 0; i < n; i++) dp[i] = matrix[0][i];


            for(int i = 1; i < m; i++){
                int[] temp = new int[n];
                for(int j = 0; j < n; j++){
                    int up = matrix[i][j] + dp[j], left = matrix[i][j], right = matrix[i][j];

                    if(j > 0) left += dp[j - 1];
                    else left = (int)Math.pow(10,9);

                    if(j < n - 1) right += dp[j + 1];
                    else right = (int)Math.pow(10,9);

                    temp[j] = Math.min(up, Math.min(left, right));

                }
                dp = temp;
            }

            for(int i = 0; i < n; i++)
                result = Math.min(result, dp[i]);

            return result;
        }


    private static int tabulation(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];

        //BASE CASE
        for(int i = 0; i < n; i++) dp[0][i] = matrix[0][i];

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                int up = matrix[i][j] + dp[i - 1][j], left = matrix[i][j], right = matrix[i][j];

                if(j> 0) left += dp[i - 1][j - 1];
               else left = (int)Math.pow(10,9);

                if(j < n - 1) right += dp[i - 1][j + 1];
             else right = (int)Math.pow(10,9);

                dp[i][j] = Math.min(up, Math.min(left, right));

                // result = Math.min(result, dp[i][j]);
            }
        }

        for(int i = 0; i < n; i++)
            result = Math.min(result, dp[m - 1][i]);

        return result;
    }


    public static int minFallingPathSum(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++)
            result = Math.min(result, solve(m - 1, i, matrix, dp));

        return result;
    }

    private static int solve(int m, int n, int[][] matrix, int[][] dp){

        if(n < 0 || n >= matrix[m].length) return Integer.MAX_VALUE;

        if(m == 0) return dp[m][n] = matrix[0][n];

        if(dp[m][n] != Integer.MAX_VALUE) return dp[m][n];

        int up = solve(m - 1, n, matrix, dp);
        int left = solve(m - 1, n - 1, matrix, dp);
        int right = solve(m - 1, n + 1, matrix, dp);

        return dp[m][n] = Math.min(Math.min(left, right), up) + matrix[m][n];

    }
}