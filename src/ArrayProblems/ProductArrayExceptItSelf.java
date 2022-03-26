package ArrayProblems;

import java.util.Arrays;

class ProductArrayExceptItSelf {
    public static void main(String[] args) {
        ///[]
        int[]nums={-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf11(nums)));

    }
    public static int[] productExceptSelf11(int[] nums) {
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
    public int[] productExceptSelf1(int[] nums) {
        //bruute force
        //time limit exceeded
        int[]ans=new int[nums.length];
        int product=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    
                    product*=nums[j];
                    if(nums[j]==0){
                        break;
                    }
                }
            }
            ans[i]=product;
            product=1;
        }
        return ans;
    }
}