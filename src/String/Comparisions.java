package String;

import java.util.HashMap;
import java.util.Map;

public class Comparisions {
    public char findTheDifference(String s, String t) {
        if(s.length()==0)return t.charAt(0);
        Map<Character,Integer> map=new HashMap();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        char ans=' ';
        for(int i=0;i<t.length();i++){
            if(map.get(t.charAt(i))!=0){
                ans=t.charAt(i);
            }
        }
        return ans;
    }
}
