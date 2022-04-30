package BackTracking;

import java.util.*;

class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
      List<List<String>> ans=new ArrayList<>();
      char[][]nums=new char[n][n];
      for (char[] row:nums) {
          Arrays.fill(row, '.');
      }
      solve(nums,0,n,ans);
      return ans;

    }

    private static void solve(char[][] nums, int row, int n, List<List<String>> ans) {
        if (row==n){
            ans.add(format(nums));
            return;
        }
        for (int col = 0; col <n ; col++) {
            if (isSafe(nums,row,col,n)){
                nums[row][col]='Q';
                solve(nums,row+1,n,ans);
                nums[row][col]='.';
            }

        }

    }

    private static List<String> format(char[][] nums) {
        List<String>ans=new ArrayList<>();
        for (char[]row:nums){
            ans.add(new String(row));
        }
        return ans;
    }

    private static boolean isSafe(char[][] nums, int row, int col, int n) {
        for (int i = 0; i <row ; i++) {
            if (nums[i][col]=='Q')return false;
        }
        for (int i = row-1,j=col-1; i >=0&&j>=0 ; i--,j--) {
            if (nums[i][j]=='Q')return false;
        }
        for (int i = row-1,j=col+1; i >=0&&j<n ; i--,j++    ) {
            if (nums[i][j]=='Q')return false;
        }
        return true;
    }
}