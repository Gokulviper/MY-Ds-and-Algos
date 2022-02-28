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
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 2 * nums.length - 1; i >= 0; --i) {
                while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                    stack.pop();
                }
                res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
                stack.push(i % nums.length);
            }
            return res;

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
