package Graph.DFSandBFS;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][]grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaOfIsland m=new MaxAreaOfIsland();
        System.out.println( m. maxAreaOfIsland(grid));
    }
    boolean [][]seen;
    private  int maxAreaOfIsland(int[][] grid) {
     int max_area=0;
            seen=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                max_area=Math.max(max_area,bfs(i,j,grid));
            }
        }
return max_area;
    }

    private int bfs(int i, int j, int[][] grid) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||seen[i][j]||grid[i][j]==0){
            return 0;
        }
        seen[i][j]=true;
       return (1+ bfs(i+1,j,grid)+bfs(i-1,j,grid)+bfs(i,j-1,grid)+bfs(i,j+1,grid));
    }
}
