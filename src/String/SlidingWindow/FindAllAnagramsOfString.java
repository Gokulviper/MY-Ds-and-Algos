package String.SlidingWindow;

import java.util.*;

class FindAllAnagramsOfString {
    public static void main(String[] args) {
 String  s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagra(String s, String p) {
        int[]char_counts=new int[26];
        for (char ch:p.toCharArray()){
            char_counts[ch-'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int left=0,right=0,count=p.length();
        while (right<s.length()){
            if (char_counts[s.charAt(right++)-'a']-->=1)count--;
            if (count==0)ans.add(left);
            if (right-left==p.length()&&char_counts[s.charAt(left++)-'a']++>=0)count++;
        }
        return ans;

    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] char_counts = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (char c: p.toCharArray()) char_counts[c - 'a']++;
        int left=0,right=0,count=p.length();
        while (right<s.length()){
            if (char_counts[s.charAt(right++)-'a']-- >=1)count--;
            if (count==0)ans.add(left);
            if (right-left==p.length()&&char_counts[s.charAt(left++)-'a']++>=0)count++;
        }
        return ans;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        //time limit exceeded
        char ana[]=p.toCharArray();
        Arrays.sort(ana);
        String anagram=String.valueOf(ana);
        int n=p.length();
        String temp="";
      List<Integer>list=new ArrayList<>();
      for (int i=0;i<s.length()-(n-1);i++){
           int k=0;
          for (int j=i;k<p.length();j++,k++){
              temp+=s.charAt(j);
          }
          char[]check=temp.toCharArray();
          Arrays.sort(check);
          String val=String.valueOf(check)   ;
          if (anagram.equals(val)){
              list.add(i);
          }
          temp="";
      }
      return list;
    }
}