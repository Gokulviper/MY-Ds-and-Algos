package DynamicProgramming.SubSequence;

public class SubsetSumEqulasK {
    public static void main(String[] args) {
        int[]nums={3,5,6,7};
        System.out.println(f(nums,nums.length-1,15));
    }

    private static boolean f(int[] nums, int index, int target) {
        if (target==0){
            return true;
        }
        if (index==0){
            return nums[index]==target;
        }
        boolean not_take=f(nums,index-1,target);
        boolean take=false;
        if (nums[index]<=target){
            take=f(nums,index-1,target-nums[index]);
        }
        return take||not_take;
    }

}
