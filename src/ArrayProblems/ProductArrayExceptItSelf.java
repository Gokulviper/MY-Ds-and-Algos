package ArrayProblems;

import java.util.Arrays;

class ProductArrayExceptItSelf {
    public static void main(String[] args) {
        ///[]

        int[]nums={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf1(nums)));

    }
    public static int[] productExceptSelf1(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int product=nums[0];
        //first pass cumulative multiply
        for(int i=1 ; i<n ; i++){
            result[i]=product;
            product*=nums[i];
        } result[0]=product;
        product=nums[n-1];
        for(int i=n-2 ; i>0 ; i--){
            result[i]*=product;
            product*=nums[i];
        }

        return result;
    }
    public static int[] productExceptSelfUsingDivision(int[] nums) {
        int[]ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for(int j=0;j<nums.length;j++){
                if (j!=i)
                prod*=nums[j];
            }
            ans[i]=prod;
        }
        return ans;
    }
    public static int[] productExceptSelf(int[] nums) {

        int product=1;
        for (int num:nums){
            if (num!=0)
            product*=num;
        }
        int no=product;
        for (int i=0;i<nums.length;i++){
           if (nums[i]!=0) {
               nums[i] = product / nums[i];
               product = no;
           }else{
               nums[i]=0;
           }
        }
        return nums;
    }

}