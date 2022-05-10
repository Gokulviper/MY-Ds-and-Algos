package DynamicProgramming.Grid;

import java.util.Arrays;

class MinimumPathSum {
    public static void main(String[] args) {
        int[][]nums={{1,3,1},{1,5,1},{4,2,1}};
        int[][]dp=new int[nums.length][nums[0].length];
        for (int[]row:dp) {
            Arrays.fill(row,-1);
        }
        System.out.println(Tabulation(nums));
    }

    private static int Tabulation(int[][] nums) {
        int[][]dp=new int[nums.length][nums[0].length];
        for (int[]row:dp) {
            Arrays.fill(row,-1);
        }
        int row=nums.length-1,col=nums[0].length-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums[0].length ; j++) {
                if (i==0&&j==0){
                    dp[i][j]=nums[i][j];
                }else{
                    int up=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
                  if(i>0) { up=nums[i][j]+dp[i-1][j];}
                  if (j>0){
                      down=nums[i][j]+dp[i][j-1];
                  }
                  dp[i][j]=Math.min(up,down);
                }
            }
        }
        return dp[nums.length-1][nums[0].length-1];
    }


    private static int memoriazation(int[][] nums, int row, int col, int[][] dp) {
        if(row==0&&col==0)return nums[row][col];
        if(row<0||col<0)return Integer.MAX_VALUE;
        if (dp[row][col]==-1){
            dp[row][col]=nums[row][col]+Math.min(memoriazation(nums,row-1,col,dp),memoriazation(nums,row,col-1,dp));
        }
        return dp[row][col];
    }

    private static int minPathSum(int[][]nums,int row,int col){
        if(row==0&&col==0)return nums[row][col];
        if(row<0||col<0)return Integer.MAX_VALUE;
        
       return nums[row][col]+Math.min(minPathSum(nums,row-1,col),minPathSum(nums,row,col-1));
    }
}