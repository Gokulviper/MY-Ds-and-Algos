package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Nqueens2 {
    int count = 0;

    public static void main(String[] args) {
        Nqueens2 n = new Nqueens2();
        System.out.println(n.totalNQueens(2));
    }

    public int totalNQueens(int n) {


        char[][]nums=new char[n][n];
        for(char[]row:nums){
            Arrays.fill(row,'.');
        }
        solve(n,nums,0);
        return count;
    }
    public  void solve(int n,char[][]nums,int row){
        if(row==n){
          count++;
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(n,row,col,nums)){
                nums[row][col]='Q';
                solve(n,nums,row+1);
                nums[row][col]='.';
            }
        }
    }
    private  boolean isSafe(int n,int row,int col,char[][]nums){
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

}