package ArrayProblems.SubArray;

import java.util.*;

public class ShortestUnSortedContinuouesSubArray {
    public static void main(String[] args) {
 int[]nums={  2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                min=Math.min(min,nums[i]);
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]<nums[i]){
                max=Math.max(max,nums[i]);
            }
        }
        int left,right;
        for(left=0;left<nums.length;left++){
            if(min<nums[left]){
                break;
            }
        }
        for(right=nums.length-1;right>=0;right--){
            if(max>nums[right]){
                break;
            }
        }
        return right-left<=0?0:right-left+1;
    }
        public static int findUnsortedSubarray2(int[] nums) {
        ///idea
            //is any unsorted violation make at the start point i

            //go the end of loop get the last violation at the end point
            //j-i+1
            int left = nums.length, right = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        right = Math.max(right, j);
                        left = Math.min(left, i);
                    }
                }
            }
            return right - left < 0 ? 0 : right - left + 1;
        }
    public static int findUnsortedSubarray1(int[] nums) {
        //sorting
        ///idea
        //is any unsorted violation make at the start point i

        //go the end of loop get the last violation at the end point
        //j-i+1
     int[]nums1=nums.clone();
     int left=nums.length-1,right=0;
        Arrays.sort(nums1);
     for (int i=0;i< nums1.length;i++){
         if (nums[i]!=nums1[i]){
             left=Math.min(left,i);
             right=Math.max(right,i);
         }
     }
     return right-left<=0?0:right-left+1;
    }
    public int findUnsortedSubarray4(int[] nums) {
        Stack < Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
    public int findUnsortedSubarrayBrute(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= nums.length; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }
                if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
                    continue;
                int k = 0;
                while (k < i && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k != i)
                    continue;
                k = j;
                while (k < nums.length && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k == nums.length) {
                    res = Math.min(res, j - i);
                }
            }
        }
        return res;
    }

}
