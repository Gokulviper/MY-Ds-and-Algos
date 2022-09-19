package BFS;

import java.util.*;

class cell{
    int row;
    int col;
    int obsRemoved;

    public cell(int x, int y, int o){
        row= x;
        col =y;
       obsRemoved = o;
    }
}

class MinimumRemoveObstacle {
    public static void main(String[] args) {
        int[][]mat={{0,1,1},{1,1,0},{1,1,0}};
        System.out.println(minimumObstacles(mat));
    }
    
 static    public int minimumObstacles(int[][] grid) {

         int n=grid.length,m=grid[0].length;
         int[][]minObsRemoved=new int[n][m];
         for(int[] r:minObsRemoved)Arrays.fill(r,Integer.MAX_VALUE);
         Deque<cell> balanceCells=new LinkedList();
         balanceCells.add(new cell(0,0,0));
         int[][]dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
         minObsRemoved[0][0]=0;
         while(!balanceCells.isEmpty()){
             int size=balanceCells.size();
             while(size-->0){
                 cell currentCell=balanceCells.poll();
                 int rowNumber=currentCell.row;
                 int columnNumber=currentCell.col;
                 for(int[]directions:dir){
                     int currentRow=rowNumber+directions[0];
                     int currentCol=columnNumber+directions[1];
                     if(currentRow>=0&&currentCol>=0&&currentRow<n&&currentCol<m){
                         if(grid[currentRow][currentCol]==1){
                             if(currentCell.obsRemoved+1<minObsRemoved[currentRow][currentCol]){
                                 minObsRemoved[currentRow][currentCol]=currentCell.obsRemoved+1;
                                 balanceCells.addLast(new cell(currentRow,currentCol,currentCell.obsRemoved+1));
                             }
                         }else{
                             if(currentCell.obsRemoved<minObsRemoved[currentRow][currentCol]){
                                 minObsRemoved[currentRow][currentCol]=currentCell.obsRemoved;
                                 balanceCells.addFirst(new cell(currentRow,currentCol,currentCell.obsRemoved));
                             }

                         }
                     }
                 }
             }
         }
         return minObsRemoved[n-1][m-1];
     }
 }