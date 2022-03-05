package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[]nums={1,2,3,4,3};
        int[]ans=nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));

    }
        public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
           for (int i=0;i<nums.length;i++){
               int next=Integer.MIN_VALUE;
               for (int j=i+1;j<nums.length;j++){
                   if (nums[i]<nums[j]){
                       next=nums[j];
                       break;
                   }
               }
               if (next==-1){
                   for (int j=0;j<i;j++){
                       if(nums[i]<nums[j]){
                           next=nums[j];
                           break;
                       }
                   }
               }
               ans[i]=next==Integer.MIN_VALUE?-1:next;
               next=-1;
           }
           return ans;
    }
    public static int[] nextGreaterElements1(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer>stack=new Stack<>();
        for (int i=2*n-1;i>=0;i--){
            while (!stack.isEmpty()&&nums[stack.peek()]<=nums[i% n]){
                stack.pop();
            }
            ans[i%n]=stack.isEmpty()?-1:nums[stack.peek()];
            stack.push(i% n);
        }
        return ans;
    }

}
