package Recursion.ArrayQuestions;

public class LinearSearch {
    public static void main(String[] args) {
        int[]nums={5,8,3,8,0,3};
        System.out.println(linearSearch(nums,0,8));
    }
    private static int linearSearch(int[] nums,int i,int target) {
        if (i==nums.length){
            return -1;
        }
        if (nums[i]==target){
            return i;
        }
        return linearSearch(nums,i+1,target);
    }
}
