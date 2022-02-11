package String;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
     String   s = "rat", t = "car";
        System.out.println(isAnagram(s,t));
    }
 /*   public static List<List<String>> groupAnagrams(String[] str) {
        //tc- O(nklogk)
        //take a string and sort the string store the key for the map
        //if any string at the same add the value
        //or create new key value pair
        if(str.length==0)return new ArrayList<>();
        Map<String,List> map=new HashMap<>();
        for(String s:str){
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if (!map.containsKey(key))map.put(key,new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }*/
 public static boolean isAnagram(String s, String t) {
     if (s.length() != t.length()) return false;
     char ch1[] = s.toCharArray();
     char ch2[] = t.toCharArray();
     Arrays.sort(ch1);
     Arrays.sort(ch2);
     int i = 0;
     while (i < s.length() ) {
         if(ch1[i]!=ch2[i]) {
             return false;
         }
         i++;

     }
     return true;
 }
    public boolean isAnagram1(String s, String t) {
     //optimize approach
        if (s.length() != t.length()) return false;
        Map<Character,Integer> map=new HashMap();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i))>0){
                    map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);

                }else{
                    return false;
                }
            }else{

                return false;
            }
        }
        return true;
    }
 }

