package DynamicProgramming.Grid;

import java.util.*;

public class Triangle {
    public static void main(String[] args) {
  int[][]triangle={{2},{3,4},{6,5,7},{4,1,8,3}};
  int[][]dp= {{-1},{-1,-1},{-1,-1,-1},{-1,-1,-1,-1}};

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

    public int tabulation(List<List<Integer>> t) {
        int[][]dp=new int[t.size()][t.size()];
        for(int i=0;i<t.size();i++){
            dp[t.size()-1][i]=t.get(t.size()-1).get(i);
        }

        for(int i=t.size()-2;i>=0;i--){
            for(int j=t.get(i).size()-1;j>=0;j--){
                int d=t.get(i).get(j)+dp[i+1][j];
                int di=t.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]= Math.min(d,di);
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
