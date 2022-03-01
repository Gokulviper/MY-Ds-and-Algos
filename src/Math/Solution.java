package Math;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SingleNumberOthersAreAppearThreeTimes {
    public static void main(String[] args) {
        int[]nums={0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        //this is optimize apporch
        //algorithm
        //take two variable ones and twos
        //make the number with  xor and complement with another number the
        //first varible is exactly is firsr time
        int ones=0;
        int twos=0;
        for (int num:nums){
            ones=(ones^num)&(~twos);
            twos=(twos^num)&(~ones);
        }
        return ones;
    }

    private static int singleNumber1(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num:nums){
            if (map.get(num)==1){
                return num;
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
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
    public int singleNumber4(int[] nums) {
        //using sort and clusters sort and make 3 shifts
        // check  the current before element
        Arrays.sort(nums);
        if(nums.length==1)return nums[0];//case 1:value in the first palce
        if(nums[0]!=nums[1])return nums[0];//case 2:value in the last palce
        if(nums[nums.length-1]!=nums[nums.length-2])return nums[nums.length-1];
        for(int i=1;i<nums.length;i+=3){
            if(nums[i]!=nums[i-1]){
                return nums[i-1];
            }
        }
        return 0;
    }
}