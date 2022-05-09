package DynamicProgramming.Grid;

public class AllPathsWithObstacles {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] nums,int row,int col) {
     if (row>=0&&col>=0&&nums[row][col]==1)return 0;
     if (row==0&&col==0)return 1;
     if (row<0||col<0)return 0;
     int count=0;
     count=count+uniquePathsWithObstacles(nums,row-1,col);
     count=count+uniquePathsWithObstacles(nums,row,col-1);
     return count;
    }
    public int memoriazation(int[][] nums, int row, int col,int[][]dp) {
        if (row>=0&&col>=0&&nums[row][col]==1)return 0;
        if (row==0&&col==0)return 1;
        if (row<0||col<0)return 0;
        if (dp[row][col]==-1) {
            int count = 0;
            count = count + memoriazation(nums, row - 1, col, dp);
            count = count + memoriazation(nums, row, col - 1, dp);
          dp[row][col]= count;
        }
        return dp[row][col];
    }
    public int Tabulation(int[][] nums) {
        int row=nums.length, col=nums[0].length;
        int[][]dp=new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int count=0;
                    if (i > 0)count+=dp[i-1][j];
                    if (j>0)count+=dp[i][j-1];
                    dp[i][j]=count;
                }
            }
        }
        return dp[row-1][col-1];
    }
}
