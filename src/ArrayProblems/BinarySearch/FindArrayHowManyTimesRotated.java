package ArrayProblems.BinarySearch;



public class FindArrayHowManyTimesRotated {
    public static void main(String[] args) {
        int[]nums={1,2,3,5};
        System.out.println(rotationCount(nums));
    }
    static int rotationCount(int[]nums){
         return pivott(nums)==-1?0:pivott(nums)+1;
    }
    private static int pivott(int[] nums) {
        int start=0,end=nums.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (mid<end&&nums[mid]>nums[mid+1]){
                return mid;
            }
            if (mid>start&&nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if (nums[start]<=nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
    static int rotationCount1(int[]nums){
        for (int i=1;i<nums.length;i++){
            if (nums[i-1]>nums[i]){
                return i;
            }
        }
        return 0;

    }
}
