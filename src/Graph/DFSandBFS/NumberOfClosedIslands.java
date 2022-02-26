package Graph.DFSandBFS;

class NumberOfClosedIslands  {
    public int closedIsland(int[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                {
                    if(dfs(grid, i, j)) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }
    
    public boolean dfs(int[][]grid, int i, int j) {
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return true;
        }   

        if((i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1) && grid[i][j] == 0) {
            return false;
        }

        grid[i][j] = 1;

        boolean first = dfs(grid, i-1, j);
        boolean second = dfs(grid, i+1, j);
        boolean third = dfs(grid, i, j-1);
        boolean fourth = dfs(grid, i, j+1);

        return first && second && third && fourth;
    }
}