package ArrayProblems.Hashing;

import java.util.*;

public class ContigousArray {
    public static void main(String[] args) {
        int nums[]={0,1,0,1,1,1};
      ;
        System.out.println(  findMaxLength(nums));

    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length ; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
   public static int findMaxLength1(int[] nums) {

        int max=Integer.MIN_VALUE;
        for (int i=0;i< nums.length;i++){
            int zeros=0,ones=0;
            for (int j=i;j< nums.length;j++){
                if (nums[j]==0){
                    zeros++;
                }else {
                    ones++;
                }
                if (zeros==ones){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;

    }}