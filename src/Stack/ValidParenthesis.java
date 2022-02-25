package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("{{()}}"));

    }
    public static boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for (char ch: s.toCharArray()){
            if(ch=='{'||ch=='['||ch=='('){
                stack.push(ch);
            } else if(ch == ')' || ch == '}' || ch == ']') {

                if(stack.isEmpty()){
                    return false;
                }else{
                        char top=stack.peek();
                        if((ch==')'&&top=='(')||(ch=='}'&&top=='{')||(ch==']'&&top=='[')){
                            stack.pop();
                        }else{
                            return false;
                        }
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

}
