package String.SlidingWindow;

import java.util.*;

class FindRepatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
       Map<String,Integer> map=new HashMap<>();
        int len=10;
    List<String> ans=new ArrayList<>();
        for(int i=0;i<=s.length()-len;i++){
            String sub=s.substring(i,i+len);
            map.put(sub,map.getOrDefault(sub,0)+1);
            
        }
        for(String str:map.keySet()){
            if(map.get(str)>1){
                ans.add(str);
            }
        }
        return ans;
    }
}