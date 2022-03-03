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
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(isOperator(s)){
                int a = stack.pop();
                int b = stack.pop();
                int ans  = calculate(a,b,s);
                stack.push(ans);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
    private static boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");


    }
    private static int calculate(int n1,int n2,String token){
        if(token.equals("+")) return n2+n1;
        if(token.equals("-")) return n2-n1;
        if(token.equals("*")) return n2*n1;
        if(token.equals("/")) return n2/n1;
        return -1;
    }
}
