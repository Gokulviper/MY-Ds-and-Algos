package ArrayProblems.Sorting.GeneralAlgorithms;
//also calles as sinking sort/exchange sort

//inplace sorting algorithm  - constant  space algorithms

import java.util.Arrays;

//tc
//o(n)-array is soretd -bestcase
//o(n^2)-array is sorted in decendind order
//
public class BubbleSort {
    public static void main(String[] args) {
        int[]nums={0,0,4,0,3,4,2,445};
        bubbleSort1(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort1(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            boolean iss=false;
            for (int j = 1; j <nums.length-i ; j++) {
                if (nums[j]<nums[j-1]){
                    iss=true;
                    int t=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=t;
                }
            }
            if (iss)break;
        }
    }

    public static void bubbleSort(int[]nums){

        for (int i = 0; i < nums.length ; i++) {
            boolean   swapped=false;
            for (int j = 1; j < nums.length-i; j++) {
                //after the first pass the largest element comes to end
                //so wre dont check the last exceted so we put nums.length-i
                if(nums[j]<nums[j-1]){
                    int t=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=t;
                    swapped=true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

}
