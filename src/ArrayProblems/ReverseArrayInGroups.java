package ArrayProblems;

import java.util.Arrays;

public class ReverseArrayInGroups {
    public static void main(String[] args) {
        int[]nums={1,3,4,6,7,8,9};
        reverseGrops(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverseGrops(int[] nums, int k) {
        for (int i = 0; i < nums.length; i+=k) {
            reverse(nums,i,Math.min(i+k-1,nums.length-1));
        }
    }
    private static void reverse(int[]nums,int start,int end){
        while (start<end){
            int t=nums[start];
            nums[start]=nums[end];
            nums[end]=t;
            start++;end--;
        }
    }
}
