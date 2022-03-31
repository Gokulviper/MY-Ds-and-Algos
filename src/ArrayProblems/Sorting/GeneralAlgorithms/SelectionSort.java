package ArrayProblems.Sorting.GeneralAlgorithms;

import java.util.Arrays;

//select the largest element in the array put at the correct index
//best case: n^2
//worst case: n^2
//its perform well in small list and arrays
public class SelectionSort {
    public static void main(String[] args) {
        int[]nums={6,4,76,2,7,2,};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));

    }
    static void selectionSort(int[]nums){
        for (int i = 0; i < nums.length; i++) {
            int last=nums.length-i-1;
            int maxIndex=getMaxIndex(nums,0,last);
            int temp=nums[last];
            nums[last]=nums[maxIndex];
            nums[maxIndex]=temp;
        }
    }

    private static int getMaxIndex(int[] nums, int start, int end) {
        int max=start;
        for (int i = start; i <=end; i++) {
          if (nums[max]<nums[i]){
              max=i;
          }
        }
        return max;
    }
}
