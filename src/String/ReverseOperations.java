package String;

import java.util.Stack;

public class ReverseOperations {
    public static void main(String[] args) {

        System.out.println(buddyStrings("aaaaaaabc","aaaaaaacb"));


    }
    public static boolean buddyStrings(String s, String goal) {
        String ans="";
        for(int i=s.length()-1;i>=0;i--){
            ans+=s.charAt(i);
        }
        return ans.equals(goal);

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
    public static String reverseOnlyLetters(String S) {
        //tc,sc=O(n)
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }

        return ans.toString();
    }
}
