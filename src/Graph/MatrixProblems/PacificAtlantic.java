package Graph.MatrixProblems;

import java.util.*;

class PacificAtlantic {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList();
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] a = new boolean[row][col];//this visted valid water flow are from atlantic
        boolean[][] p = new boolean[row][col];//this visted valid water flow are from pacidic

        for (int i = 0; i < row; i++) {  //we make the calls on the evevry edge
            //make dfs first full coum for  pacific

            dfs(i, 0, heights, p, heights[i][0]);
            //this colum for atlanctic
            dfs(i, col - 1, heights, a, heights[i][col - 1]);
        }
        for (int i = 0; i < col; i++) {
            //same the row is for pacific
            dfs(0, i, heights, p, heights[0][i]);
            //this for atlantic
            dfs(row - 1, i, heights, a, heights[row - 1][i]);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < col; j++) {
                //after make the both atlantic and pacfic is valid
                //how is this valid
                //both are true and they can flow over the conditon
                if (a[i][j] && p[i][j]) {
                    ans.add(new ArrayList((Arrays.asList(i, j))));
                }
            }
        }
        return ans;

    }

    void dfs(int row, int col, int[][] heights, boolean[][] vis, int prev) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length ||
                vis[row][col] || prev > heights[row][col]) {
            return;
        }
        vis[row][col] = true;
        dfs(row + 1, col, heights, vis, heights[row][col]);
        dfs(row - 1, col, heights, vis, heights[row][col]);
        dfs(row, col + 1, heights, vis, heights[row][col]);
        dfs(row, col - 1, heights, vis, heights[row][col]);
    }
}