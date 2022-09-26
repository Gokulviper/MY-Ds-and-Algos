package DynamicProgramming.Grid;

class DungeaonGame {
    int recursion(int[][]d, int r, int c){
        if(r==d.length-1&&c==d[0].length-1){
            return d[r][c]>=0?1:-d[r][c]+1;
        }
        if(r==d.length||c==d[0].length)return Integer.MAX_VALUE;
        int ans=Math.min(recursion(d,r+1,c), recursion(d,r,c+1))-d[r][c];
        return ans<=0?1:ans;
    }
    public int calculateMinimumHP(int[][] dungeon) {
    int r=dungeon.length,c=dungeon[0].length;
        int[][]dp=new int[r+1][c+1];
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
          if(i==r-1&&j==c-1){
          dp[i][j]=Math.min(0,dungeon[i][j]);    
          }else if(i==r-1){
       dp[i][j]=Math.min(0,dungeon[i][j]+dp[i][j+1]);       
          }else if(j==c-1){
      dp[i][j]=Math.min(0,dungeon[i][j]+dp[i+1][j]);        
          }else{
      dp[i][j]=Math.min(0,dungeon[i][j]+Math.max(dp[i+1][j],dp[i][j+1]));        
          }      
            }
        }
        return Math.abs(dp[0][0])+1;
    }
}