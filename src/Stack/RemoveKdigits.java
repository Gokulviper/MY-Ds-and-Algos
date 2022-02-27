package Stack;

import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        System.out.println(removeKDigits("24234345",3));

    }

    private static String removeKDigits(String s,int k) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (char ch:s.toCharArray()){
            while (!stack.isEmpty()&&stack.peek()>ch&&k-->0){
                stack.pop();
            }
            if(stack.isEmpty()&&ch=='0')continue;
            stack.push(ch);
        }
        while (!stack.isEmpty()&&k-->0){
            stack.pop();
        }
        if (stack.isEmpty())return "0";
        while (!stack.isEmpty()){
           sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
