package String;

import java.util.Arrays;
import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        String s=
                "EPY2giL";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
            if (s.isEmpty()||s==null)return "";
           int i=0;
           while (i<s.length()&&s.charAt(i)==' '){
               i++;
           }
        Stack<String> stack=new Stack<>();
           String temp="";
           for (;i<s.length();i++){
               if (!Character.isWhitespace(s.charAt(i))){
                   temp+=s.charAt(i);
               }else  if (Character.isWhitespace(s.charAt(i))){
                   if(!temp.isEmpty()) stack.push(temp);
                   temp="";
               }
           }
           if (!temp.isEmpty())stack.push(temp);
           StringBuilder ans=new StringBuilder();
           while (!stack.isEmpty()){
               ans.append(stack.pop());
              if (!stack.isEmpty()){ans.append(" ");}
           }
           return ans.toString();

    }
}
