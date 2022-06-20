package ArrayProblems.SlidingWindow;

import java.util.HashMap;

class MiniumWindowSubstring {
    public static void main(String[] args) {
   String     s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {

     if(t.length() > s.length()) return "";
    HashMap<Character, Integer> map = new HashMap<>();
    for(char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
    int i = 0;
    int j = 0;
    String result = "";
    int min_length = Integer.MAX_VALUE;
    int count = map.size();
    while(j < s.length() || count == 0){  //we can maintain count as a changable
        if(count > 0){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1); //we find the value must decrement
                if(map.get(ch) == 0) count--;
            }
            j++;
        }
        else{
            if(count == 0 && j-i+1 < min_length){  //the count is zero we found one of our answer and update
                min_length = j-i+1;
                result = s.substring(i,j);
            }
            char ch = s.charAt(i);  //we need insert the current current key
            if(map.containsKey(s.charAt(i))){ //and
                map.put(ch, map.get(ch) + 1);
                if(map.get(ch) > 0) count++;
            }
            i++;
        }
    }
    return result;
}
}