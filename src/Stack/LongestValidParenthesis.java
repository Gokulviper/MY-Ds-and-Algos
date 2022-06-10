package Stack;

import java.util.Stack;

;

public class LongestValidParenthesis {
    public int usingStack(String s) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) =='(') {
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    max=Math.max(max,i-stack.peek() );
                }
            }
        }
        return max;
    }
    public int spaceOptimized(String s) {
    int max=0;
        int left=0,right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else if(s.charAt(i)==')'){
                right++;
            }
            
            if(left==right){
                max=Math.max(max,left+right);
            }else if(right>=left){
                left=right=0;
            }
        }
         left=right=0;
        for(int i=s.length()-1;i>=0;i--){
              if(s.charAt(i)=='('){
                left++;
            }else if(s.charAt(i)==')'){
                right++;
            }
            
            if(left==right){
                max=Math.max(max,right+left);
            }else if(left>=right){
                left=right=0;
            }
        }
        return max;
    }
}