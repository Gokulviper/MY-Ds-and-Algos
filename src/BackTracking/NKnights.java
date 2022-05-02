package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n=4;
        System.out.println(Nknights(n));
    }

    private static List<List<String>> Nknights(int n) {
        char[][]board=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        for (char[]num:board){
            Arrays.fill(num,'.');
        }
        solve(n,board,0,0,ans);
        return ans;
    }

    private static void solve(int n, char[][] board, int row, int col, List<List<String>> ans) {
        if (n==0){
            ans.add(foramtedList(board));
            return;
        }
        if (row==board.length){
            return;
        }
        if (col==board.length){
            solve(n,board,row+1,col,ans);
        }

        if (isSafe(board,n,row,col)) {
            board[row][col] = 'K';
            solve(n-1,board,row,col+1,ans);

            board[row][col]='.';
        }
        solve(n,board,row,col+1,ans);
    }
    private static boolean isSafe(char[][] board, int n, int row, int col) {
      if (isValid(board,row-2 ,col-1)){
          if (board[row-2][col-1]=='K'){
              return false;
          }
      }
        if (isValid(board,row-1,col-2)){
            if (board[row-1][col-2]=='K'){
                return false;
            }
        }
        if (isValid(board,row-2,col+1)){
            if (board[row-2][col+1]=='K'){
                return false;
            }
        }
        if (isValid(board,row-1,col+2)){
            if (board[row-1][col+2]=='K'){
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        if(row>=0&&row<board.length&&col>=0&&col<board[0].length){
            return true;
        }
        return false;
    }

    private static List<String> foramtedList(char[][] board) {
        List<String> result = new ArrayList<>();
        for(char[] row : board) {
            result.add( new String( row ) );
        }
        return result;
    }
}
