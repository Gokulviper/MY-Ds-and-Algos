package BFS;

import java.util.*;

class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ones = 0;
        Queue<Ord> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    q.add(new Ord(i, j, grid[i][j]));
                } else if(grid[i][j] == 1) {
                    ones ++;
                }
            }
        }
        int time = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for(int k=0;k<size;k++) {
                Ord o = q.poll();
                int i = o.i;
                int j = o.j;
                vis[i][j] = true;
                if(o.val == 1) grid[i][j] = 2;
                if(i>0 && !vis[i-1][j] && grid[i-1][j] == 1) {
                    q.add(new Ord(i-1, j, grid[i-1][j]));
                    vis[i-1][j] = true;
                    ones--;
                }
                if(j>0 && !vis[i][j-1] && grid[i][j-1] == 1) {
                    q.add(new Ord(i, j-1, grid[i][j-1]));
                    vis[i][j-1] = true;
                    ones--;
                }
                if(i<m-1 && !vis[i+1][j] && grid[i+1][j] == 1) {
                    q.add(new Ord(i+1, j, grid[i+1][j]));
                    vis[i+1][j] = true;
                    ones--;
                }
                if(j<n-1 && !vis[i][j+1] && grid[i][j+1] == 1) {
                    q.add(new Ord(i, j+1, grid[i][j+1]));
                    vis[i][j+1] = true;
                    ones--;
                }
                
            }
        }
        if(ones != 0) return -1;
        return time == 0 ? time : time-1;
    }
    
    public class Ord {
        int i;
        int j;
        int val;
        Ord(int _i, int _j, int _val) {
            this.i = _i;
            this.j = _j;
            this.val = _val;
        }
    }
}