package ArrayProblems.BinarySearch;

public class CelingInCharcterArray {
    public static void main(String[] args) {
        char []ch={'c','d','f','h','z'};
        System.out.println(nextGreatestLetter(ch,'e'));

    }
    public static char nextGreatestLetter(char[] nums, char target) {
         int start=0,end=nums.length-1;
         while (start<=end){
             int mid=start+(end-start)/2;
           if(nums[mid]>target){
                 end=mid-1;
             }else {
                 start=mid+1;
             }
         }
         return nums[start%nums.length];

    }

}
