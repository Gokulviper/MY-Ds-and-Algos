package ArrayProblems.CyclicSort;

import java.util.Arrays;

//hint of cyclic 1 to n
public class CyclicSort {
    public static void main(String[] args) {
     int[]nums={5,3,2,1,4};
     cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }
     static void cyclicSort(int[]nums){
        int i=0;
        while (i<nums.length){
            int correctIndex=nums[i]-1;
            if (nums[i]!=nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else i++;
        }
    }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}

