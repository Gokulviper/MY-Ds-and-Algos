package BackTracking.Array;

class MaximamGold {
    int max;
    public int getMaximumGold(int[][] grid) {
        int row=grid.length,col=grid[0].length;
       boolean[][]vis=new boolean[row][col];
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0)
               f(grid,i,j,vis,0);
            }
        }
        return max;
    }
    void f(int[][]nums,int row,int col,boolean[][]vis,int cur){
        if(row<0||col<0||row>=nums.length||col>=nums[0].length||vis[row][col]||nums[row][col]==0){
            max=Math.max(cur,max);
            return;
        }
     
        vis[row][col]=true;
        f(nums,row+1,col,vis,cur+nums[row][col]);
          f(nums,row-1,col,vis,cur+nums[row][col]);
          f(nums,row,col+1,vis,cur+nums[row][col]);
          f(nums,row,col-1,vis,cur+nums[row][col]);
        vis[row][col]=false;
        
        
    }
}