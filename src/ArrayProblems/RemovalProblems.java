package ArrayProblems;

import java.util.HashMap;

public class RemovalProblems {
    public static void main(String[] args) {

    }
    public int removeDuplicates2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j< nums.length;j+=1){
            if(nums[j]!=nums[i]){
                i+=1;
                nums[i]=nums[j];
            }
        }return i+1;

    }
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap();

        for (int i = 0; i < nums.length; i += 1) {
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i += 1) {

            int check = hs.get(nums[i]);
        }
        return ans;
    }
}
