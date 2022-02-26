package ArrayProblems.BinarySearch;

class Solution {
    public static void main(String[] args) {
        int []nums={3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate2(nums));
    }

    private static int singleNonDuplicate(int[] nums) {

    }
    private static int singleNonDuplicate2(int[] nums) {
        int unique=0;
        for (int num:nums){
            unique^=num;
        }
        return unique;

    }

    public static int singleNonDuplicate3(int[] nums) {

        //o(n)
        if(nums.length==1)return nums[0];
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}