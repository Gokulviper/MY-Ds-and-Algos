package ArrayProblems;

import java.util.Stack;

class find123 {
    public static void main(String[] args) {
int[]nums={3,5,0,3,4};//[]
        System.out.println(find132pattern(nums));
    }
    //// The idea hides at locating the correct s3, which is in middle.
    //// Start reading from right of array and keep on adding in the stack until you get some element(s2)
    // which is bigger than top element (s3) of stack (s2 means that in array this number arrives before s3)
    //
    //// TC: O(N)
    //// SC: O(N)
    public static boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < s3) {
                return true;
            } else {
                while(!st.isEmpty() && nums[i] > st.peek()) { // when nums[i] > top element in the stack,
  // it means that we have encountered a number s2 which has atleat one number
  // (s3) at its right which is smaller than s2, so this will find s3 (s1 < s3 < s2),
  // after finding s3, all we need to find whether there is any number smaller than s3 (s1) at left
                    s3 = st.pop();
                }
                st.push(nums[i]);
            } }
        return false;
    }
    public static boolean find132pattern1(int[] nums) { //i=1,j=3,k=2
        //not working all test cases
        for (int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=i+2;
            if(nums[i]<nums[k]&&nums[k]<nums[j]&&nums[i]<nums[j]){
                return true;
            }
        }
        return false;
    }
}