package BFS;

import java.util.*;

public class WallsAndGates {
    public static int[][] wallsAndGates(int[][] a, int n, int m) {
      int dis=0;
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==0){
                    q.add(i*m+j);
                }
            }
        }
        boolean[][]vis=new boolean[n][m];
        int[][]dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            int size=q.size();
            dis++;
            while(size-->0){
                int node=q.poll();
                int r=node/m;
                int c=node%m;
                for(int[]d:dir){
                    int row=r+d[0];
                    int col=c+d[1];
                    if(row>=0&&col>=0&&row<n&&col<m&&!vis[row][col]&&a[row][col]==Integer.MAX_VALUE){
                        vis[row][col]=true;
                        a[row][col]=dis;
                        q.add(row*m+col);
                    }
                }
            }
        }
        return a;
    }
}
