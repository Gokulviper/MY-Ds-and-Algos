package ArrayProblems.BinarySearch;

public class PeakIndex {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] nums) {
        int start=0,end=nums.length;
        while (start<end){
            int mid=start+(end-start)/2;
            if (nums[mid]>nums[mid+1]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;

    }
    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}