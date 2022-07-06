package String.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
    public static void main(String[] args) {
       String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        Map<Character,Integer>map=new HashMap<>();
        for (char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        int start=0,end=0;
        int min=Integer.MAX_VALUE;
        String ans="";
        while (end<s.length()||count==0){
            if (count>0){
                if (map.containsKey(s.charAt(end))){
                    map.put(s.charAt(end),map.get(s.charAt(end))-1);
                    if (map.get(s.charAt(end))==0){
                        count--;
                    }
                }
                end++;
            }else{
                if (count==0&&end-start+1<min){
                    min=end-start+1;
                    ans=s.substring(start,end);
                }
                if (map.containsKey(s.charAt(start))) {

                    map.put(s.charAt(start),map.get(s.charAt(start))+1);
                    if (map.get(s.charAt(start))>0)count++;
                }
                start++;
            }
        }
        return ans;
    }
}