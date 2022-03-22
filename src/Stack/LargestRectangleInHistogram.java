package Stack;

import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
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
        
        int maxA = 0; 
        for(int i = 0;i<n;i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA; 
        
    }
}