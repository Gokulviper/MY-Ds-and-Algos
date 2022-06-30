package String.SlidingWindow;

import java.util.*;

class Solution {
    public static void main(String[] args) {

    }
    public List<Integer> findSubstring(String s1, String[] words) {
        int[]hash1=new int[26];
        int[]hash2=new int[26];
        String s2="";
      for(String ss:words){
          s2+=ss;
      }
        List<Integer> ans=new ArrayList();
        for(int i=0;i<s2.length();i++){
            hash1[s1.charAt(i)-'a']++;
            hash2[s2.charAt(i)-'a']++;
        }
        int end=s2.length(),start=0;
    for(;end<s1.length()-1;end++){
        if(match(hash1,hash2)){
            ans.add(start);
        }
        hash2[s2.charAt(end)-'a']++;
        hash2[s2.charAt(start++)-'a']--;
        
    }
        if(match(hash1,hash2)){
            ans.add(start);
        }
        return ans;
    }
    private boolean match(int[]hash1,int[]hash2){
        for(int i=0;i<hash1.length;i++){
            if(hash1[i]!=hash2[i]){
                return false;
            }
        }
        return true;
    }
}