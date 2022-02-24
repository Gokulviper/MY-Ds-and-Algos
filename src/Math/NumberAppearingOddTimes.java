package Math;

import java.util.HashMap;
import java.util.Map;

public class NumberAppearingOddTimes {
    public static void main(String[] args) {
        int[] nums={1,6,3,6,1,8,8,8,6,1};
        System.out.println(singleNumber1(nums));
    }

    private static int singleNumber(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            count=0;
            for(int j=0;j<nums.length;j++){

                if(nums[i]==nums[j]){
                    count++;
                }

            }
            if(count==1){
                return nums[i];
            }
        }
        return 0;
    }
    private static int singleNumber1(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.get(num)==1){
                return num;
            }
        }
        return 0;
    }

}
