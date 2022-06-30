package String.SlidingWindow;

import java.util.*;

class SubStringWithConcatenationOfSubstrings {
    public static void main(String[]a){
        String s = "barfoofoobarthefoobarman";
        String[]wors={"bar","foo","the"};
        System.out.println(findSubstring(s,wors));
    }
    public static List<Integer> findSubstring(String s1, String[] words) {
        int[]hash1=new int[26];
        int[]hash2=new int[26];
        String s2="";
      for(String ss:words){
          s2+=ss;
      }
        List<Integer> ans=new ArrayList();
      Set<Integer>set=new HashSet<>();
        for(int i=0;i<s2.length();i++){
            hash1[s2.charAt(i)-'a']++;
            hash2[s1.charAt(i)-'a']++;
        }
        int len=words[0].length();
        if(match(hash1,hash2)){
            ans.add(0);
        }
        int end=s2.length(),start=0;
    while(end<s1.length()){

        int num=0;
        while (num<len) {
            hash2[s1.charAt(end++) - 'a']++;
            hash2[s1.charAt(start++) - 'a']--;
            num++;
        }
        if(match(hash1,hash2)){
            ans.add(start);
        }
    }

        return ans;
    }
    private static boolean match(int[]hash1,int[]hash2){
        for(int i=0;i<hash1.length;i++){
            if(hash1[i]!=hash2[i]){
                return false;
            }
        }
        return true;
    }
}