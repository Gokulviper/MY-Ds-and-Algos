package String.SlidingWindow;

import java.util.HashSet;

class LengthLongestWithoutRepatingCharacters {
    public static void main(String[] args) {
    String    s = "abcabcbb";
        System.out.println( lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        //sliding window
        int max=0, left=0,right=0;
        HashSet<Character>hashSet=new HashSet<>();
        while (right<s.length()){
            if (!hashSet.contains(s.charAt(right))){
                hashSet.add(s.charAt(right++));
              max=  Math.max(max,hashSet.size());
            }else{
                hashSet.remove(s.charAt(left++));
            } }
        return max;
    }
}