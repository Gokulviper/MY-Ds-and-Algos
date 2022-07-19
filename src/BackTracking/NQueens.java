package BackTracking;

import java.util.*;

class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList();
        char[][]nums=new char[n][n];
        for(char[]row:nums){
            Arrays.fill(row,'.');
        }
        solve(n,nums,0,ans);
        return ans;
    }
    public static void solve(int n,char[][]nums,int row, List<List<String>> ans){
        if(row==n){
            ans.add(new ArrayList(format(nums)));
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(n,row,col,nums)){
                nums[row][col]='Q';
                solve(n,nums,row+1,ans);
                nums[row][col]='.';
            }
        }
    }
    private static boolean isSafe(int n,int row,int col,char[][]nums){
        for(int i=0;i<n;i++){
            if(nums[i][col]=='Q')return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(nums[i][j]=='Q')return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(nums[i][j]=='Q')return false;
        }
        return true;
    }
    private static List<String> format(char[][]nums){
        List<String> ans=new ArrayList();
        for(char[]row:nums){
            ans.add(new String(row));
        }
        return ans;
    }
}