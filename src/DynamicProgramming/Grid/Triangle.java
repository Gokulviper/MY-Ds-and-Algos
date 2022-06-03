package DynamicProgramming.Grid;

import java.util.*;

public class Triangle {
    public static void main(String[] args) {
  int[][]triangle={{2},{3,4},{6,5,7},{4,1,8,3}};
  int[][]dp= {{-1},{-1,-1},{-1,-1,-1},{-1,-1,-1,-1}};
        System.out.println(Tabluation(triangle));
    }
    public int memo(List<List<Integer>> t) {
        int[][]dp=new int[t.size()][t.size()];
        for(int row[]:dp)Arrays.fill(row,-1);
        return f(t,0,0,dp);
    }
    int f(List<List<Integer>> t, int row, int col, int[][]dp){
        if(row>=t.size())return Integer.MAX_VALUE;
        if(row==t.size()-1)return t.get(row).get(col);
        if(dp[row][col]==-1){
            int d=t.get(row).get(col)+f(t,row+1,col,dp);
            int di=t.get(row).get(col)+f(t,row+1,col+1,dp);
            dp[row][col]= Math.min(d,di);
        }
        return dp[row][col];
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
