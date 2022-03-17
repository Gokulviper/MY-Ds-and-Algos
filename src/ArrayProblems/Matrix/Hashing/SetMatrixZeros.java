package ArrayProblems.Matrix.Hashing;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][]matrix = {{0,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        print(matrix);

    }


        public static void setZeroes(int[][] matrix) {
Boolean isCal=false;
int row=matrix.length;
int col=matrix[0].length;
    for (int i=0;i<row;i++){
        if (matrix[i][0]==0){
            isCal=true;
        }
        for (int j=1;j<col;j++){
            if (matrix[i][j]==0){
                matrix[i][0]=0;
                matrix[0][j]=0;
            }
        }
    }
    for (int i=1;i<row;i++){
        for (int j=1;j<col;j++){
            if(matrix[i][0]==0||matrix[0][j]==0){
                matrix[i][j]=0;
            }
        }
    }
    if (matrix[0][0]==0){
        for (int i=0;i<col;i++){
            matrix[0][i]=0;
        }
    }
    if (isCal){
        for (int i=0;i<row;i++){
            matrix[i][0]=0;
        }
    }
        }

    static void setMatrixZerosBruteForce(int[][]nums){
        //tc=0(m*n)
        //sc=0(m+n)
        Set<Integer>rows=new HashSet<>();
        Set<Integer>cols=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                if (nums[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                } } }
        for (int i=0;i< nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (rows.contains(i)|| cols.contains(j)){
                    nums[i][j]=0;
                } } } }
    static void print(int[][]nums){
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
}
