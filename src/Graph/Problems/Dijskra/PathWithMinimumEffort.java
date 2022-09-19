package Graph.Problems.Dijskra;

import java.util.*;

class pairs{
    int row,col,w;
    pairs(int r,int c,int ww){
        row=r;
        col=c;
        w=ww;
    }
}
class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        int[][]dis=new int[n][m];
        for(int[]r:dis) Arrays.fill(r,Integer.MAX_VALUE);
        dis[0][0]=0;
        PriorityQueue<pairs> pq=new PriorityQueue<>((a,b)->a.w-b.w);
        pq.add(new pairs(0,0,0));
        int[][]dir={{-1,0},{0,-1},{1,0},{0,1}};
        while(!pq.isEmpty()){
            pairs p=pq.poll();
            int r=p.row;
            int c=p.col;
           
            for(int []d:dir){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0&&col>=0&&row<n&&col<m){
                    int curDis=Math.max(p.w,Math.abs(heights[r][c]-heights[row][col]));
                    if(curDis<dis[row][col]){
                        dis[row][col]=curDis;
                        pq.add(new pairs(row,col,curDis));
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
}