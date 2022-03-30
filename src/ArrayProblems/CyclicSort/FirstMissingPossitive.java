package ArrayProblems.CyclicSort;

import java.util.Arrays;

class FirstMissingPossitive {
    public static void main(String[] args) {
        int[]nums={2,1};
        System.out.println(firstMissingPositive(nums));

    }
    public static int firstMissingPositive(int[] nums) {
        cyclicSort(nums);
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static void cyclicSort(int[]nums){
        int i=0;
        while(i< nums.length){
            int correct =nums[i]-1;
            if(nums[i]>0&&nums[i]<=nums.length&&nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else i++;
        }
    }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}
