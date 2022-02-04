package String;

import java.util.Stack;

public class ReverseOperations {
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
    public static String reverseString(String s){
        char[] ch=s.toCharArray();
        String ans="";
        int start=0,end=ch.length-1;
        while (start<=end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start+=1;
            end-=1;
        }
        String s1=ch.toString();
        return s1;
    }

    public static boolean validPalindrome(String s) {
        int start=0,end=s.length()-1;
        while (start<end){
            if(s.charAt(start)==s.charAt(end)){
                start+=1;
                end-=1;
            }else{
                return isPallindromeDeletingOneElement(s,start+1,end)|| isPallindromeDeletingOneElement(s,start,end-1);
            }
        }
        return true;
    }

    private static boolean isPallindromeDeletingOneElement(String s, int start, int end) {
        while (start<end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
