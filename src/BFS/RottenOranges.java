package BFS;

import java.util.*;

class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Integer>rottenOrangesStorage=new LinkedList<>() ;
        int freshOranges=0,totalTimeTaken=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (grid[i][j]==1){
                    freshOranges++;
                }else  if(grid[i][j]==2){
                    rottenOrangesStorage.add(i*m+j);
                }
            }
        }
        if (freshOranges==0)return 0;
        int[][]dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        while (!rottenOrangesStorage.isEmpty()){
            int size=rottenOrangesStorage.size();
            while (size-->0){
                int cellNumber=rottenOrangesStorage.poll();
                int row=cellNumber/m;
                int col=cellNumber%m;
                for(int[]d:dir){
                    int newRow=row+d[0];
                    int newCol=col+d[1];
                    if(newRow>=0&&newCol>=0&&newCol<m&&newRow<n&&grid[newRow][newCol]==1){
                 rottenOrangesStorage.add(newRow*m+newCol);
                 grid[newRow][newCol]=2;
                 freshOranges--;
                 if (freshOranges==0)return totalTimeTaken+1;
                    }
                }
            }
            totalTimeTaken++;
        }
        return -1;
    }
}