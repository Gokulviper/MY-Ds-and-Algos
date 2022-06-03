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

            int[] prev = new int[n];

            //BASE CASE
            for(int i = 0; i < n; i++) prev[i] = matrix[0][i];


            for(int i = 1; i < m; i++){
                int[] cur = new int[n];
                for(int j = 0; j < n; j++){
                    int up = matrix[i][j] + prev[j], left = matrix[i][j], right = matrix[i][j];

                    if(j > 0) left += prev[j - 1];
                    else left = (int)Math.pow(10,9);

                    if(j < n - 1) right += prev[j + 1];
                    else right = (int)Math.pow(10,9);

                    cur[j] = Math.min(up, Math.min(left, right));

                }
                prev = cur;
            }

            for(int i = 0; i < n; i++)
                result = Math.min(result, prev[i]);

            return result;
        }


    private static int tabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiagonal= Integer.MAX_VALUE;
                if(j-1>=0) leftDiagonal = matrix[i][j]+dp[i-1][j-1];


                int rightDiagonal =Integer.MAX_VALUE;
                if(j+1<m) rightDiagonal =matrix[i][j]+ dp[i-1][j+1];

                dp[i][j] = Math.min(up, Math.min(leftDiagonal,rightDiagonal));

            }
        }

        int maxi = Integer.MAX_VALUE;

        for(int j=0; j<m;j++){
            maxi = Math.min(maxi,dp[n-1][j]);
        }

        return maxi;
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