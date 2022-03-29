package ArrayProblems.CyclicSort;

import java.util.Arrays;

class SetMisMatch {
    public static void main(String[] args) {
        int[]nums={1,1};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    public int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return new int[]{nums[i],nums[i]+1};
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] findErrorNums(int[] nums) {
        sort(nums);
        for (int i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{-1,-1};
    }
    private static void sort(int[]nums){
    int i=0;
    while (i<nums.length){
        int correct=nums[i]-1;
        if(nums[i]!=nums[correct]){
            swap(nums,i,correct);
        }else i++;
    }

    }
    static   void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}