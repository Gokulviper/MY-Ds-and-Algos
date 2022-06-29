package ArrayProblems.Hashing;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArryaEqualNumberOnesAndZeros {
    public static void main(String[] args) {
        int[]nums={1,0,0,1,0,1,1,1};
        System.out.println(find(nums));;
    }

    private static int find(int[] nums) {
        int start=0,end=0;
        Map< Integer, Integer > map = new HashMap< >();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                if(i - map.get(count)>maxlen) {
                    maxlen = Math.max(maxlen, i - map.get(count));
                    start=map.get(count);
                    if (start==-1){
                        start++;
                    }
                    end=i;
                }
            } else {
                map.put(count, i);
            }
        }
        System.out.println(start);
        System.out.println(end);
        return maxlen;
    }
}
