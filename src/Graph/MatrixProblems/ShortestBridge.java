package Graph.MatrixProblems;

import java.util.*;
public class ShortestBridge {



    public static void main(String[] args) {
     //   grid = [[],[],[],[],[]]
        int[][]grid={{1,1,1,1,1},
                    {1,0,0,0,1},
                    {1,0,1,0,1},
                    {1,0,0,0,1},
                    {1,1,1,1,1}};
        System.out.println(shortestBridge(grid));
    }
    public static int shortestBridge(int[][] grid) {
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length && !flag; i++){//make the one island is fully 2
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid,q);
                    flag = true;
                    break;
                }
            }
        }
         int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while(!q.isEmpty()){
            int[] u = q.poll();
            int row = u[0], col = u[1], dist = u[2];//the queue first is row second is col and thrid is distance
            for(int[] dir : dirs){
                int i = row + dir[0], j = col + dir[1];
                if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
                    if(grid[i][j] == 1) return dist;//we find the one that is nect island return the distacne
                    if(grid[i][j] == 0) {   //you find the 0 is increment the distance
                        q.add(new int[]{i, j, dist+1});
                        grid[i][j] = 2; //make that is 2
                    }
                }
            }
        }
        return -1;
    }
    private static void dfs(int i, int j, int[][] grid, Queue<int[]> q){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = 2;
        q.add(new int[]{i, j, 0});
        dfs(i, j-1, grid, q);
        dfs(i, j+1, grid, q);
        dfs(i-1, j, grid, q);
        dfs(i+1, j, grid, q);
    }
}