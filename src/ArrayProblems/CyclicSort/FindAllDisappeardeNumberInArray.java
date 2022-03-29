package ArrayProblems.CyclicSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FindAllDisappeardeNumberInArray {
    public static void main(String[] args) {
        int[]nums={1,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        cyclicSort(nums);
  List<Integer>ans=new ArrayList<>();
  // if index+1 not equal to the current nums[i]
        for (int i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                ans.add(i+1);
            }
        }
        return ans;
        
    }
    public static void cyclicSort(int[]nums){
        int i=0;
        while (i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,correct,i);
            }else i++;
        }
    }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}