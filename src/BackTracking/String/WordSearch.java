package BackTracking.String;

class WordSearch {
    public static void main(String[] args) {
        char[][]nums={{'A','B','C','E'},{'S','C','F','S'},{'A','D','E','E'}};
        System.out.println(exist(nums,"BCF"));

    }
  static   boolean[][]visited;
    public static boolean exist(char[][] board, String word) {
       visited=new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j]==word.charAt(0)&&find(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean find(char[][] board, String word, int r, int c, int index) {
        if (index==word.length()){
            return true;
        }
        if (r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]!=word.charAt(index)||visited[r][c]){
            return false;
        }
      visited[r][c]=true;
        if ((find(board,word,r+1,c,index+1))||(find(board,word,r-1,c,index+1))||
        (find(board,word,r,c+1,index+1))||(find(board,word,r,c-1,index+1))){
            return true;
        }
     visited[r][c]=false;
return false;
    }


}