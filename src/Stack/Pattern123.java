package Stack;

import java.util.Stack;

class Pattern123 {
    public static void main(String[] args) {
        int[]nums={3,1,4,2};
        System.out.println(find132pattern(nums));
    }
    public static boolean find132pattern(int[] nums) {
    int s3=Integer.MIN_VALUE;
        Stack<Integer> stack=new Stack();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<s3){
                return true;
            }else{
                while(!stack.isEmpty()&&stack.peek()<nums[i]){
                    s3=stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
}