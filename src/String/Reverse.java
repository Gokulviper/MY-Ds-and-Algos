package String;

import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));

    }
    public static String reverseWords(String s) {
        Stack<String> stack=new Stack();
        String temp="",ans="";
        int i=0;
        while (i<s.length()&&s.charAt(i)==' ')i++;

       for(;i<s.length();i++){

           if(s.charAt(i)==' '){

                    if(!temp.isBlank())
               stack.push(temp);
               temp="";

           }
           if(s.charAt(i)!=' ')
           temp+=s.charAt(i);
       }
      if(!temp.isBlank()) stack.push(temp);
       while (!stack.isEmpty()){
           if(stack.size()>1) {
               ans = ans + stack.pop() + " ";
           }
           if(stack.size()==1) ans = ans + stack.pop();
       }
       return ans;
    }
}
