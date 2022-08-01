package Stack.MonotonicstackProblems;

import java.util.Stack;

public class SubArraysumMinimums {
    public static void main(String[] args) {
        int[]nums={11,81,94,43,3};
        System.out.println(sumSubarrayMins(nums));
    }
    private static final long MOD = 1_000_000_007;

    public static int sumSubarrayMins(int[] nums) {
        Stack<Integer> monoStk = new Stack<Integer>();
        int[] leftDist = new int[nums.length];
        int[] rightDist = new int[nums.length];
        long sum = 0;

        for(int i = 0; i < nums.length; i++){
            while(!monoStk.isEmpty() && nums[i] <= nums[monoStk.peek()]) monoStk.pop();

            leftDist[i] = monoStk.isEmpty() ? i+1 : i-monoStk.peek();
            monoStk.push(i);
        }
        monoStk.clear();

        for(int i = nums.length-1; i >= 0; i--){
            while(!monoStk.isEmpty() && nums[i] < nums[monoStk.peek()]) monoStk.pop();

            rightDist[i] = monoStk.isEmpty() ? nums.length-i : monoStk.peek()-i;
            monoStk.push(i);
        }

        for(int i = 0; i < nums.length; i++)
            sum = (sum + (long)nums[i]*leftDist[i]*rightDist[i]) % MOD;

        return (int)sum;
    }
}
