package Stack.MonotonicstackProblems;

import java.util.Stack;

class MaxiMamRectangle {
    public static void main(String[] args) {
        char[][]matrix={{'1','0','1','0','1'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},

        };
        System.out.println(maximalRectangle(matrix));
    }
    
    //smaller on left
 public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int l[]=new int[n];
        int r[]=new int[n];
        Stack<Integer> stack=new Stack();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
           l[i]=stack.isEmpty()?0:stack.peek()+1;
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            r[i]=stack.isEmpty()?n-1:stack.peek()-1;
            stack.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(heights[i]*(r[i]-l[i]+1)));
        }
        return ans;
    }
    
    public static int maximalRectangle(char[][] matrix) {
        int n= matrix[0].length;
        int arr[] = new int[n];
        int area=0;
        
        for(int r=0;r<matrix.length ;r++){
           for(int c=0;c<n;c++){
               if(matrix[r][c]=='0' ){
                   arr[c] =0;
               }
               else{
                   arr[c]+=1;
               }
           }
            area=Math.max(area,largestRectangleArea(arr));
        }
        
       return area;
    }
}