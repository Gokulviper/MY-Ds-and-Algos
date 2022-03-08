package ArrayProblems.BinarySearch;

public class CeilingAndFloor {
    public static void main(String[] args) {
        int[]nums={3,4,6,7,9,11,34,77};
        System.out.println(floor(nums,2));
    }

    private static int ceiling(int[] nums,int target) {
        if(target>nums[nums.length-1]){
            return -1;
        }
        int start=0,end=nums.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                 start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
    private static int floor(int[] nums,int target) {
        if(target<nums[nums.length-1]){
            return -1;
        }
        int start=0,end=nums.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }

}
