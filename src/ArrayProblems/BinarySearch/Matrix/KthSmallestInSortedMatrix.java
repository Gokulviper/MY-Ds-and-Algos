package ArrayProblems.BinarySearch.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
// [[],[],[]], k = 8
        int[][]nums={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(nums,8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left < right){
            int mid = left + (right - left)/2;
            int count = seachMatrix(matrix,mid);
            //find how many numbers are smaller than mid element
            if(count < k){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return right;
    }

    public static int seachMatrix(int[][] matrix, int target) {
        //start from last column of first row.
        int count = 0;
        int row = 0;
        int col_max = matrix[0].length-1;

        //move down or left to find the element
        while(row < matrix.length && col_max >= 0){
            if(matrix[row][col_max] > target) col_max--;
            else {
                count = count + col_max + 1;
                row++;
            }
        }

        return count;
    }
    public static int kthSmallest1(int[][] nums, int k) {
        List<Integer> ans=new ArrayList<>();
        for (int i=0;i< nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                ans.add(nums[i][j]);
            }
        }
        int[] a=new int[ans.size()];
        for (int i=0;i<a.length;i++){
            a[i]=ans.get(i);
        }
        Arrays.sort(a);
        return a[k-1];
    }
}