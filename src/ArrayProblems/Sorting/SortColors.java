package ArrayProblems.Sorting;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[]nums={2,1,2,1,0,2,2,1,0,1};
        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int start=0,mid=0,end=nums.length-1;
        while (mid<=end){
           if(nums[mid]==0){
               swap(nums,start,mid);
        mid++;
               start++;
           }
           else if(nums[mid]==1){
               mid++;
           }else if(nums[mid]==2){
               swap(nums,end,mid);

               end--;
           }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}
