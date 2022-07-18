package BackTracking;

class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    boolean backtrack(char[][]board){
        for(int row = 0; row < board.length; row++) { // Simple Matrix traversal
        for(int col = 0; col < board[0].length; col++) {
            
            if(board[row][col] == '.') { //We find an empty place to fill
                
                for(char num = '1'; num <= '9'; num++) {
                    
                    if(isValid(board, row, col, num)) { // If we can place the number
                        board[row][col] = num; // We place it
                        
                        //next recursive call. If it returns true then we placed the number correctly.
                        if(backtrack(board) ) {
                            return true;
                                                  
                        } else { // Removing the number if not placed correctly
                            board[row][col] = '.';
                        }
                    }
                }
                return false; //If we don't find any number valid we return false.
            }
        }
    }
    return true;
}

boolean isValid(char[][] board, int row, int col, char num) {
    
    for(int i = 0; i < 9; i++) {
        
        if(board[row][i] == num) { //Checking for row
            return false;
        }
        
        if(board[i][col] == num) { //Checking for column
            return false;
        }
        
        if(board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == num) { //Checking the Grid
            return false;
        }
    }
    return true;
} 
}