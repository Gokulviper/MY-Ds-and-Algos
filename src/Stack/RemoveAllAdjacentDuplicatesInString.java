package Stack;

import java.util.Calendar;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String str) {
        Stack<Character>stack=new Stack<>();
        for (char ch: str.toCharArray()){
            if (!stack.isEmpty()&&stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
