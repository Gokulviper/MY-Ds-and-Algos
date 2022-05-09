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
}
