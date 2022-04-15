package Recursion.ArrayQuestions;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[]nums={8,8,3,8,8,3};
        System.out.println(linearSearchReturnList(nums,0,8));
    }

    private static ArrayList<Integer> linearSearchReturnList(int[] nums, int i, int target) {
        ArrayList<Integer> list=new ArrayList<>();
        if (i==nums.length){
            return list;
        }
        if (nums[i]==target){
            list.add(i);
        }
        ArrayList<Integer> ansBelowCalls=linearSearchReturnList(nums,i+1,target);
        list.addAll(ansBelowCalls);
        return list;
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
