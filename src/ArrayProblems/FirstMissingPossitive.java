package ArrayProblems;

import java.util.Arrays;

class FirstMissingPossitive {
    public static void main(String[] args) {
        int[]nums={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missing=1;
        for (int num:nums){
            if (num>missing){
                return num;
            }
            else if (num==missing){
                missing++;
            }
        }
        return nums[nums.length-1];
    }
}