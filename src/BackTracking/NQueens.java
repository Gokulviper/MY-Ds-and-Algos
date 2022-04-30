package BackTracking;

import java.util.*;

class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // Create n*n board and fill it with dots "."
        char[][] board = new char[n][n];

        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Call recursive function for 0th row
        solveNQueens(board, n, 0, result);

        return result;
    }

    private static void solveNQueens(char[][] board, int n, int row, List<List<String>> result) {
        /* If all the queens have been placed in current path,
        put the formatted result into list and backtrack. */
        if( row == n ) {
            result.add( formatResult( board ) );
            return;
        }

        /* Try to place the queen in each column of the current row */
        for(int col=0; col<n; col++) {

            // Check current queen is safe at current column in the row
            if( isSafe( board, n, row, col ) ) {

                // Place the queen at current column
                board[row][col] = 'Q';

                // Try to place the next queen in the row
                solveNQueens(board, n, row+1, result);

                /* Remove the queen after the current combination has been
                tried */
                board[row][col] = '.';
            }
        }
    }
    private static boolean isSafe(char[][] board, int n, int row, int col) {


        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
    private static List<String> formatResult(char[][] board) {
        List<String> result = new ArrayList<>();
        for(char[] row : board) {
            result.add( new String( row ) );
        }
        return result;
    }
}