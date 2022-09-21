package Graph.BFS;

import java.util.PriorityQueue;
class pairs{
    int row,col,values;
    pairs(int row,int col, int values){
        this.row=row;
        this.col=col;
        this.values=values;
    }
}
class TrappingRainWater3 {
    public int trapRainWater(int[][] heightMap) {
     int n=heightMap.length,m=heightMap[0].length;
     PriorityQueue<pairs> pq=new PriorityQueue<pairs>((a, b)->a.values-b.values);
        boolean[][]vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||i==n-1||j==m-1){
                    pq.add(new pairs(i,j,heightMap[i][j]));
                    vis[i][j]=true;
                }
            }
        }
     int[][]dir=new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        while(!pq.isEmpty()){
            pairs node=pq.poll();
            int r=node.row;
            int c=node.col;
            for(int[]d:dir){
                int row=d[0]+r;
                int col=d[1]+c;
                if(row>=0&&col>=0&&row<n&&col<m&&!vis[row][col]){
                    vis[row][col]=true;
                    ans+=Math.max(node.values-heightMap[row][col],0);
                 heightMap[row][col]=Math.max(node.values,heightMap[row][col]);   
              pq.add(new pairs(row,col,heightMap[row][col]));
                }
            }
        }
        return ans;
    }
}