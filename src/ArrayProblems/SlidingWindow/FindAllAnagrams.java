package ArrayProblems.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

class FindAllAnagrams {
    public static void main(String[] args) {

    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        int[]hash=new int[26];
        for(char ch:p.toCharArray()){
            hash[ch-'a']++;
        }
        int left=0,right=0,count=p.length();
       while (right<s.length()){
           if (hash[s.charAt(right++)-'a']-->=1)count--;
           if (count==0)ans.add(left);
           if (right-left+1>p.length()&&hash[s.charAt(left++)-'a']++>=0)count++;
       }
       return ans;
    }
}