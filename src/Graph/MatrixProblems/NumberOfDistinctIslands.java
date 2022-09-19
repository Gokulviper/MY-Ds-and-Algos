package Graph.MatrixProblems;

import java.util.HashSet;

class NumberOfDistinctIslands {

    int countDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0;i < grid.length;i++)
        {
            for(int j = 0;j < grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    String p = print(i,j,grid,"X");
                    set.add(p);
                }
                
            }
        }
        return set.size();
    }
    private static String print(int i,int j,int[][]grid,String start)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
        {
            return "O";
        }
        grid[i][j] = 0;
        
        String left = print(i,j-1,grid,"L");
        String right = print(i,j+1,grid,"R");
        String top = print(i - 1,j,grid,"U");
        String down = print(i+1,j,grid,"D");
        
        return start + left + right + top + down;
    }
}