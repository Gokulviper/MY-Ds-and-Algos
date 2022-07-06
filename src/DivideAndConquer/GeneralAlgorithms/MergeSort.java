package DivideAndConquer.GeneralAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
     int[]nums={6,8,3,7,2,7,8,1,4,2,6};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }

    private static int[] mergeSort(int[] nums) {
        if (nums.length==1){
            return nums;
        }
        int mid= nums.length/2;
        int [] left=mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[]right=mergeSort(Arrays.copyOfRange(nums,mid,nums.length));

        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i=0,j=0,k=0;
        int ans[]=new int[left.length+right.length];
        while (i<left.length&&j<right.length){
            if (left[i]<=right[j]){
                ans[k++]=left[i++];
            }else{
                ans[k++]=right[j++];
            }
        }
        while (i<left.length){
            ans[k++]=left[i++];
        }
        while (j<right.length)
            ans[k++]=right[j++];
        return ans;
    }
}
