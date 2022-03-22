package Stack;

import java.util.Stack;

class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[]heights = {2,4};
        System.out.println(largestRectangleAreaBrute(heights));
    }
    public static int largestRectangleAreaBrute(int[] nums) {
        int max=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){

                int width=0;
                for (int j=0;j<nums.length;j++){
                    if(nums[j]>=nums[i]){
                        width++;
                    }else{
                        max=Math.max(max,nums[i]*width);
                        width=0;
                    }
                }
            max=Math.max(max,nums[i]*width);

        }
        return max;
    }

    public static int largestRectangleAreaBetter(int[] heights) {
        int n = heights.length; 
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n]; 
        int rightSmall[] = new int[n]; 
        for(int i = 0;i<n;i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop(); 
            }
            leftSmall[i]=st.isEmpty()?0:st.peek()+1;
            st.push(i);
        }
        // clear the stack to be re-used
        while(!st.isEmpty()) st.pop();
        for(int i = n-1;i>=0;i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop(); 
            }
            rightSmall[i]=st.isEmpty()?n-1:st.peek()-1;
            st.push(i); 
        }
        int max = 0;
        for(int i = 0;i<n;i++) {
            max = Math.max(max, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return max;
    }
}