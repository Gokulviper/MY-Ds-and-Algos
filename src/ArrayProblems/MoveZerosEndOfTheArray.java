package ArrayProblems;

import java.util.Arrays;

public class MoveZerosEndOfTheArray {
    public static void main(String[] args) {
        int[]nums={0,5,0,6,0,1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void moveZeroes(int[] nums) {
        int i=0;
        int j=0; //j handle the zeros
        for(;i<nums.length;i++){
            if(nums[i]!=0&&nums[j]==0){
                swap(nums,i,j);
                j++;
            }else if(nums[j]!=0){
                j+=1;
            }
        }

    }
    public static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}
