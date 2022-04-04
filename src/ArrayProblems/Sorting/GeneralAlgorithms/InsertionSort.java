package ArrayProblems.Sorting.GeneralAlgorithms;

import java.util.Arrays;

//move the j pointer till the end if any greater element you see swap that elemment
//worst case - n^2
//best case-0(n
// //us case
//*steps gets reduce is array is sorted
//no of swaps reduced as compared as bubble sort
//*stable-
//*used for smaller range of n ->  works good array is partially sorted
public class InsertionSort {
    public static void main(String[] args) {
        int[]nums={6,3,7,8,93,3,7,2};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));

    }
    static void insertionSort(int[]nums){
        for (int i = 0; i <nums.length-1     ; i++) {
            for (int j =i+1; j >0 ; j--) {
              if (nums[j]<nums[j-1]){
                 swap(nums,j,j-1);
              }else{
                  break;
              }
            }
        }
    }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;}
}


