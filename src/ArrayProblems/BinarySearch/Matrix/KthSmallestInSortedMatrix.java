package ArrayProblems.BinarySearch.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
// [[],[],[]], k = 8
        int[][]nums={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest1(nums,8));
    }

    public int kthSmallest(int[][] matrix, int k) {
     int n = matrix.length - 1;
// choose the smallest and biggest number
int min = matrix[0][0], max = matrix[n][n];
//do binary search
while(min < max) {
int mid = min + (max-min)/2;
//count number of items small or equal to the mid
int count = countSmallOrEqual(matrix, mid);
if (count < k) min = mid + 1;
else max = mid;
}
return min;
}

// count from left-bottom
public int countSmallOrEqual(int[][] matrix, int target) {
    int i = matrix.length-1, j = 0;
    int count = 0;
    while(i>=0 && j<matrix.length) {
        int val = matrix[i][j];
        if (val <= target) {
            count += (i+1);
            j++;
        } else {
            i--;
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