package String.SlidingWindow;

import java.util.*;

class CharacterReplaceMent {
    public static void main(String[] args) {
String  s = "AABABBA";int k = 1;
        System.out.println(characterReplacement(s,k));
        int a=2,b=7,c=10;

    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int result = 0;
        int maxFreq = 0;
        for(int j=0; j<s.length(); j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            int windowSize = j - i + 1;
            if(windowSize - maxFreq <= k) {
                result = Math.max(result, windowSize);
            } else {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                i++;
            } }
        return result;
    }
    public static int characterReplacement1(String s, int k) {
     Map<Character,Integer>map=new HashMap<>();
     int i=0,result=0,maxFreq=0;
     for (int j=0;j<s.length();j++){
         char ch=s.charAt(j);
         map.put(ch,map.getOrDefault(ch,0)+1);
         maxFreq=Math.max(maxFreq,map.get(ch));
         int windowSize=j-i+1;
         if (windowSize-maxFreq<=k){
             result=Math.max(result,windowSize);
         }else{
             char leftChar =s.charAt(i);
             map.put(leftChar,map.getOrDefault(leftChar,0)-1);
             i++;
         } }
        return result;
    }
}