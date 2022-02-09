package String;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
// strs = ["eat","tea","tan","ate","nat","bat"]
        String[] s={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));

    }
    public static List<List<String>> groupAnagrams(String[] str) {
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
    }
}
