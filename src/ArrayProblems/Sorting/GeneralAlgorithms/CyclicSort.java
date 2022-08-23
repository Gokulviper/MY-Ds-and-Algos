package ArrayProblems.Sorting.GeneralAlgorithms;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[]nums={5,4,2,3,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        int i=0;
        while (i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]-1!=i){
                int t=nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]=t;
            }else i++;
        }
    }
}
