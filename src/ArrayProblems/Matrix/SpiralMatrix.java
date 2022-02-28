package ArrayProblems.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][]nums={{1,4,6,7},
                {4,7,8,3},
                {6,9,2,8},
                {23,78,1,7}};
        System.out.println(spiralMatrix(nums));;
    }
    private static List<Integer> spiralMatri1x(int[][] nums) {
        List<Integer>ans=new ArrayList<>();
        int row=nums.length,column=nums[0].length;
        int i=0,j=0,k=0;
        while (i<column&&j<row){
            for (k=i;k<column;k++){
                ans.add(nums[j][k]);
            }
            j++;
            for (k=j;k<row;k++){
                ans.add(nums[k][column-1]);
            }
            column--;
            if(j<row){
                for (k=column-1;k>=i;k--){
                    ans.add(nums[row-1][k]);
                }
                row--;
            }
            if(i<column){
                for (k=row-1;k>=j;k--){
                    ans.add(nums[k][i]);
                }
                i++;
            }
        }
        return ans;

    }
    private static List<Integer> spiralMatrix(int[][] nums) {
        List<Integer>ans=new ArrayList<>();
        int row= nums.length,column=nums[0].length;
        int i=0;//traverse help of rows
        int j=0;//traverse help of columns
         int k=0;//traverse the all array
        while (j<row&&i<column){
            for (k=i;k<column;k++){           //left to right
               ans.add(nums[j][k]);
            }
            j++;
            for (k=j;k<row;k++){          //top to bottom
               ans.add(nums[k][column-1]);
            }
            column--;
            if (j<row){
                for (k=column-1;k>=i;k--){          //right to left
                   ans.add(nums[row-1][k]);
                }
                row--;
            }
            if (i<column){
                for (k=row-1;k>=j;k--){            //down to up
                    ans.add(nums[k][i]);
                }
               i++;
            }
        }
        return ans;
    }

}
