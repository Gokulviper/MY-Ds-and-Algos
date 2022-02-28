package ArrayProblems.Matrix;

import java.util.Arrays;

class RotateImage {
    public static void main(String[] args) {
        // [[],[],[]]
        int[][]nums={{1,2,3}
                ,{4,5,6},
                {7,8,9}};
        rotate(nums);
       print(nums);

    }

    private static void print(int[][] nums) {
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] nums) {

        transopse(nums);
        reverse(nums);
    }

    private static void transopse(int[][] nums) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums[0].length;j++){
               int t=nums[i][j];
               nums[i][j]=nums[j][i];
               nums[j][i]=t;
            }
        }
    }

    private static void reverse(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<(matrix.length/2);j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1]=t;

            }
        }
    }
}