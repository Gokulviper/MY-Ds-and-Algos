package DynamicProgramming.Grid;

public class Triangle {
    public static void main(String[] args) {
  int[][]triangle={{2},{3,4},{6,5,7},{4,1,8,3}};
        System.out.println(minimumPathSum(triangle,0,0));
    }

    private static int minimumPathSum(int[][] triangle, int row, int col) {
        if (row==triangle.length-1){
            return triangle[row][col];
        }
        return triangle[row][col]+Math.min(minimumPathSum(triangle,row+1,col),minimumPathSum(triangle, row+1, col+1));
    }
}
