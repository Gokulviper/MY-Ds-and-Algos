package ArrayProblems.Sorting;

import java.util.Arrays;

public class SortByParity {
    public static void main(String[] args) {
        int[]nums={3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity1(nums)));

    }
    public static int[] sortArrayByParity1(int[] nums) {

        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]%2>nums[j]%2){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
            if(nums[i]%2==0)i++;
            if(nums[j]%2==1)j--;
        }
        return nums;
    }
    public static void swap(int a,int b,int[]nums){

    }
    public static int[] sortArrayByParity(int[] nums) {

        int[]ans=new int[nums.length];
        int k=0;
        for(int num:nums){
            if(num%2==0){
                ans[k++]=num;
            }
        }
        for(int num:nums){
            if(num%2!=0){
                ans[k++]=num;
            }
        }
        return ans;
    }

}
