package Stack;


import java.util.Stack;

public class DailyTempratures {
    public static void main(String[] args) {

    }
    public static int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i] ){
                int prev=stack.pop();
                ans[i]=i-prev;
            }
            stack.push(i);
        }
        return ans;

    }
}
