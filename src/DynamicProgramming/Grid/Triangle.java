package DynamicProgramming.Grid;

public class Triangle {
    public static void main(String[] args) {
  int[][]triangle={{2},{3,4},{6,5,7},{4,1,8,3}};
  int[][]dp= {{-1},{-1,-1},{-1,-1,-1},{-1,-1,-1,-1}};
        System.out.println(Tabluation(triangle));
    }

    private static int Tabluation(int[][] nums) {
        int[][]dp=new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[nums.length-1][i]=nums[nums.length-1][i];
        }
        for (int i = nums.length-2; i >=0 ; i--) {
            for (int j = i; j >=0; j--) {
                dp[i][j]=nums[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    private static int minimumPathSum(int[][] triangle, int row, int col, int[][] dp) {
        if (row==triangle.length-1){
            return triangle[row][col];
        }
        if (dp[row][col]==-1) {
            dp[row][col]= triangle[row][col] + Math.min(minimumPathSum(triangle, row + 1, col, dp), minimumPathSum(triangle, row + 1, col + 1, dp));

        }
        return dp[row][col];
    }
}
