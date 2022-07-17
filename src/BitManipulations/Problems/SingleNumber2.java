package BitManipulations.Problems;

import java.util.Arrays;

class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if (nums[0] != nums[1]) return nums[0];
        int n = nums.length;
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        for (int i = 1; i < n; i += 3) {
            if (nums[i] == nums[i - 1]) {

            } else {
                return nums[i - 1];
            }
        }
        return -243;

    }
    /*
we take two variables one and twos
in this question the value appeard three times
so we handle ones and two time repeated
initailze both as zero first
take the current number  xor with ones
current number is 2-> 10
ones current value -> 00  ^
                                                                                              -----												                   10
   after & with
   complement of two 11 &																       ----												                      10 --> 2
                                                                   after the perform this the value of one time occured is changed to one
we do same for twos
xor with currentnumer and & with (~ones)
after perfroming this twos will be zero
in seconde iteration you can check the ones will be zero and twos wil be 2
because the element appears twice so in finally you can return ones
you will not understand this please dry run yourself
*

    */
    public int singleNumber1(int[] nums) {
        if(nums.length==1)return nums[0];
        int ones=0,twos=0;
        for(int num:nums){
            ones^=num&(~twos);
            twos^=num&(~ones);
        }
        return ones;
    }
}
