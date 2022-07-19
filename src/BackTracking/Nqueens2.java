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

        // Create n*n board and fill it with dots "."
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Call recursive function for 0th row
         solveNQueens(board, n, 0);

      return count;
    }

    private void solveNQueens(char[][] board, int n, int row ) {
        if(row==n){
            count++;
            return;
        }
        for (int col = 0; col <n ; col++) {


        if (isSafe(board,row,col,n)) {
            board[row][col] = 'Q';
            solveNQueens(board, n, row + 1);
            board[row][col] = '.';
        }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i <n ; i++) {
            if (board[i][col]=='Q'){
                return false;
            }
        }
        for (int i = row-1,j=col-1; i >=0&&j>=0 ; i--,j--) {
            if (board[i][j]=='Q'){
                return false;
            }
        }
        for (int i = row-1,j=col+1; i >=0&&j<n ; i--,j++) {
            if (board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}