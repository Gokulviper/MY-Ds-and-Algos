package String;

import java.util.*;

public class Hashing {
    static int ans=0;
    public static void main(String[] args) {


    }



    public static String[] uncommonFromSentences(String s1, String s2) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List ans = new ArrayList();
        for (String Word : map.keySet()) {
            if (map.get(Word) == 1) {
                ans.add(Word);
            }
        }

        return (String[]) ans.toArray(new String[ans.size()]);

    }

    public static boolean wordPattern(String pattern, String word) {
        String[] words = word.split(" ");  //push the all the words in string
        Map<Character, String> map = new HashMap();
        if (pattern.length() != words.length) return false; //edge case
        for (int i = 0; i < pattern.length(); i++) {
            char current_Char = pattern.charAt(i);
            if (map.containsKey(current_Char)) {              //the map already have the value check are equal is
                                                                    //is not equal return false
                if (!map.get(current_Char).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {        //if the contains the value that not right because already have ha value if
                    return false;                       //is must be passed we definitly return it
                }
                map.put(current_Char, words[i]);
            }

        }return true;
    }
}
