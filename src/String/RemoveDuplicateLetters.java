package String;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
    String  s = "cbaccdbc";
        System.out.println(removeDuplicateLetters(s));
    }
    public static String removeDuplicateLetters1(String s) {
        int[]lastIndex=new int[26];
        for (int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']++;
        }
        boolean[]seen=new boolean[26];
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            int currentChar=s.charAt(i)-'a';
            if (seen[currentChar])continue;
            while (!stack.isEmpty()&&stack.peek()>currentChar&&i<lastIndex[stack.peek()]){
               seen[stack.pop()]= false;
            }
            stack.push(currentChar);
            seen[currentChar]=true;
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append((char) (stack.pop()+'a'));
        }
        return sb.reverse().toString();

    }
    public static String removeDuplicateLetters(String s) {
        int[]lastIndex=new int[26];
        for (int i=0;i<s.length();i++){
                lastIndex[s.charAt(i)-'a']=i;
        }
        boolean[]seen=new boolean[26];
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            if (seen[ch])continue;
            while (!stack.isEmpty() &&stack.peek()>ch && i<lastIndex[stack.peek()]){
                seen[stack.pop()] =false;
            }
            stack.push(ch);
            seen[ch]=true;
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append((char)(stack.pop()+'a'));
        }
        return sb.reverse().toString();
    }
}
