package String;

import java.util.*;

public class Hashing {
    public static void main(String[] args) {

        String ans[]=uncommonFromSentences("this apple is sweet","this apple is sour");
       System.out.println(Arrays.toString(ans));
        String s="hi this like the maths";
        String[] r=s.split(" ");
        System.out.println( Arrays.toString(r));
    }
    public static String[] uncommonFromSentences(String s1, String s2) {

           Map<String,Integer> map=new HashMap<>();
           for(String word:s1.split(" ")){
               map.put(word,map.getOrDefault(word,0)+1);
           } for(String word:s2.split(" ")){
                map.put(word,map.getOrDefault(word,0)+1);
            }
           List ans=new ArrayList();
           for(String Word:map.keySet()){
               if(map.get(Word)==1){
                   ans.add(Word);
               }
           }

         return (String[]) ans.toArray(new String[ans.size()]);

    }
}
