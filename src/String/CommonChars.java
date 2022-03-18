package String;

import java.util.ArrayList;
import java.util.*;

class CommonChars {
    public static void main(String[] args) {
        String[]nums={ "bella","label","roller"};
        System.out.println(commonChars(nums));
    }
    public static List<String> commonChars(String[] words) {
        List<String> ans=new ArrayList<>();
        Map<Character, Integer> map=new HashMap<>();
        int value=0;
        for (String val:words){
            for (char ch:val.toCharArray()){
                map.put( ch,value);
            }
            value++;

        }
        String check=words[0];
    for (int i=0;i<check.length();i++){



    }
      return ans;
    }
}