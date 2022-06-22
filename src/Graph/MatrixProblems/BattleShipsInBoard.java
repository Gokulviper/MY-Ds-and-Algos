package Graph.MatrixProblems;

class BattleShipsInBoard {
    public static void main(String[] args) {

    }
    public int countBattleshipsOptimize(char[][] board) {
        int ans=0;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='X'){
                    //if we find the x it is a battleship
                    ans++;
                    if ((i-1>=0&&board[i-1][j]=='X')||(j-1>=0&&board[i][j-1]=='X')){
                        //if they  contnues battleship we dont make identical count that is same
                        //check the constains the current battleship is connected to any battle ship
                        //if its not dont make anything
                        //if its make the decrement count
                        ans--;
                    }
                }
            }
        }
        return ans;

    }
    public int countBattleshipsBrute(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] board, int i, int j) {
        int row = i;
        int col = j;
        if (row < 0 || row == board.length || col < 0 || col == board[row].length) {
            return;
        }
        if (board[row][col] == '.' || board[row][col] == 'N') {
            return;
        }    
        board[row][col] = 'N';
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }
}