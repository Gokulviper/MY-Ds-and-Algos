package Stack;

import java.util.Stack;

public class ValidateStackSequence {
    public static void main(String[] args) {

       int[] pushed = {1,2,3,4,5}, popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed,popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
    int n=pushed.length;
    int j=0;
    Stack<Integer>stack=new Stack<>();
        for (int num:pushed){
        stack.push(num);
        while (!stack.isEmpty()&&j<n&&stack.peek()==popped[j]){
            j++;
            stack.pop();
        }
    }
    return j==n;
    }
}
