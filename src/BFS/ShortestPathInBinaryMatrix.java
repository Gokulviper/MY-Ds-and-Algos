package BFS;

import java.util.*;
class pair{
    int row;
    int col;
    pair(int row,int col){
        this.row=row;
        this.col=col;
    }

}
class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> cells = new LinkedList<>();
        int[][] directions = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        
        if(grid[0][0] == 0) {
            cells.add(new pair(0,0));
        }
        
        int length = 0;
        while(!cells.isEmpty()) {
            length++;
            int size = cells.size();
            while(size-- > 0) {
               pair current = cells.poll();
                if(current.row == m-1 && current.col == n-1) {
                    return length;
                }
                for(int[] direction : directions) {
                    int x = direction[0] + current.row;
                    int y = direction[1] + current.col;
                    if(x >= 0 && y >= 0 && x < m && y < m && grid[x][y] == 0) {
                        cells.add(new pair(x,y));
                        grid[x][y] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
}