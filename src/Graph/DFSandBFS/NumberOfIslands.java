package Graph.DFSandBFS;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][]islands={{'1','1','1'},{'1','1','0'},{'0','0','1'},{'1','0','0'}};
        System.out.println(numberOfIslands(islands));
    }

    private static int numberOfIslands(char[][] islands) {
        int count=0;
        for (int i=0;i<islands.length;i++){
            for (int j=0;j<islands[0].length;j++){
                if(islands[i][j]=='1') {
                    count++;
                    BFS(islands, i, j);
                }
            }
        }
        return count;
    }

    private static void BFS(char[][] islands, int i, int j) {
        if(i<0||j<0||i>=islands.length||j>=islands[0].length||islands[i][j]=='0'){
            return;
        }
        islands[i][j]='0';
        BFS(islands,i+1,j);
        BFS(islands,i-1,j);
        BFS(islands,i,j+1);
        BFS(islands,i,j-1);
    }
}
