package DivideAndConquer.GeneralAlgorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[]nums={1,3,4,5,6,7,8,9};
        System.out.println(binarysearch(nums,0,nums.length,1));;
    }

    private static int binarysearch(int[] nums, int start, int end, int target) {
        if (end<0||start>nums.length){
            return -1;
        }
        int mid=(start+end)/2;
        if (nums[mid]==target){
            return mid;
        }
        if (nums[mid]<target){
        return     binarysearch(nums,mid+1,end,target);
        }
        return binarysearch(nums,start,mid,target);

    }
}
