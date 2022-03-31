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
        int[]nums={4,3,6,2,79,98};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

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
