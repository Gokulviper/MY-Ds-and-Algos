package String;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("baabacaca"));

    }
    public static String removeDuplicateLetters(String s) {
        StringBuilder sb=new StringBuilder();
        Set set=new HashSet();
        String temp="";
        for(char ch:s.toCharArray()){
            if(!set.contains(ch)){
                temp+=ch;
            }
        }
        char ch[]=temp.toCharArray();
        Arrays.sort(ch);
        String ans=String.valueOf(ch);
        return ans;
    }
}
