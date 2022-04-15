package Recursion.ArrayQuestions;

public class FindArrayIsSoretd {
    public static void main(String[] args) {
        int[]nums={1,2,3,4,6,78,};
        System.out.println(isSoretd(nums,1,true));
    }

    private static boolean isSoretd(int[] nums,int index,boolean soreted) {
        if (index==nums.length){
            return true;
        }
        if (!soreted){
            return false;
        }
        if (nums[index]<nums[index-1]){
            soreted=false;
            return soreted;
        }
        return isSoretd(nums,index+1,soreted);
    }
}
