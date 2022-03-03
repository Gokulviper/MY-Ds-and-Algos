package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
 String[]nums={"4","13","5","/","+"};
        System.out.println(evalRPN(nums));
    }
    public static int evalRPN1(String[] tokens) {
        int res=0;
        Stack<String >stack=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if(!notOperan(tokens[i])){
                stack.push(tokens[i]);
            }else{
                int a=Integer.parseInt(stack.pop());
                int b=Integer.parseInt(stack.pop());
                int ans=cal(a,b,tokens[i]);
                stack.push(""+ans);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static int cal(int a, int b, String sign) {
        if (sign.equals("+")){
            return a+b;
        }
       else if (sign.equals("-")){
            return a-b;
        }
       else if (sign.equals("*")){
            return a*b;
        }
       else if (sign.equals("/")){
            return a/b;
        }
       return 0;


    }

    private static boolean notOperan(String token) {
        return token.charAt(0)=='+'|| token.charAt(0)=='-'|| token.charAt(0)=='*'|| token.charAt(0)=='/';

    }

    public static int evalRPN(String[] tokens) {
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperand(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                int result = operate(second, first, tokens[i]);
                stack.push("" + result);
            } }

        return stack.isEmpty()?res:Integer.parseInt(stack.pop());
    }
    private static int operate(int num1, int num2, String operator) {
        if (operator.equals("/")) {
            return num1 / num2;
        }
        if (operator.equals("*")) {
            return num1 * num2;
        }
        if (operator.equals("+")) {
            return num1 + num2;
        }
        if (operator.equals("-")) {
            return num1 - num2;
        }
        return 0;
    }
    private static boolean isOperand(String ch) {
        return ch.charAt(0) == '/' ||
                ch.charAt(0) == '*' ||
                ch.charAt(0) == '+' ||
                ch.charAt(0) == '-' && ch.length() == 1;
    }
}
