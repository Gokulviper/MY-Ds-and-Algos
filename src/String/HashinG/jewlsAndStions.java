package String.HashinG;

import java.util.*;

class jewlsAndStions {
    public static void main(String[] args) {
      String  jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels,stones));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        int count=0;
        Map<Character,Integer> j=new HashMap();
        for(char ch:jewels.toCharArray()){
            j.put(ch,j.getOrDefault(ch,0)+1);
        }
          for(char ch:stones.toCharArray()) {
              if (j.containsKey(ch)) {
                      count++;

              } }
        return count;
        
    }
}