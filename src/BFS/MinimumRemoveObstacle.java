package BFS;

import java.util.*;

class Cell{
    int x;
    int y;
    int obsRemoved;

    public Cell(int x, int y, int obsRemoved){
        this.x= x;
        this.y =y;
        this.obsRemoved = obsRemoved;
    }
}

class MinimumRemoveObstacle {
    
    public int minimumObstacles(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][]minObsRemoved = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                minObsRemoved[i][j] = Integer.MAX_VALUE;
            }
        }
        // CLEARLY SEE DEQUE IS USED
        Deque<Cell> pendingCells  = new LinkedList<>();
        pendingCells.add(new Cell(0,0,0));
        minObsRemoved[0][0] = 0;
        
        int[][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!pendingCells.isEmpty()){
            Cell current = pendingCells.poll();
            for(int i=0;i<dir.length;i++){
                int newX= current.x + dir[i][0];
                int newY = current.y + dir[i][1];
                
                if(newX >= 0 && newX < m && newY >=0 && newY <n){
                    
                    // IF THE NEW CELL IS A BLOCK THEN ADD IT IN LAST
                    if(grid[newX][newY]==1){
                        // IF I CAN REVISIT THE NEW CELL WITH LESSER OBS REMOVED THEN I CAN TAKE A STEP.
                        if(current.obsRemoved+1 < minObsRemoved[newX][newY]){
                            minObsRemoved[newX][newY] = current.obsRemoved+1;
                            pendingCells.addLast(new Cell(newX,newY,current.obsRemoved+1));
                        }
                    }
                    //IF THE NEW CELL IS A FREE CELL ADD IT IN FRONT
                    else{
                        if(current.obsRemoved < minObsRemoved[newX][newY]){
                            // IF I CAN REVISIT THE NEW CELL WITH LESSER OBS REMOVED THEN I CAN TAKE A STEP.
                            minObsRemoved[newX][newY] = current.obsRemoved;
                            pendingCells.addFirst(new Cell(newX,newY,current.obsRemoved));
                        }
                    }
                }
            }
        }
        
        return minObsRemoved[m-1][n-1];
    }
}