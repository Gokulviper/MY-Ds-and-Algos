package ArrayProblems.BinarySearch;

public class SearchInInfinteSortedArray {
    public static void main(String[] args) {

    }
    static  int findInInfinite(int[]nums,int target){
        int start=0,end=1;
        while (target>nums[end]){
          int temp=end;
            end=end+(end-start+1)*2;
            start=temp;
        }
        return binarySearch(nums,start,start,end);

    }
    static int binarySearch(int[]nums,int target,int start,int end){
        while (start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }

        }
        return -1;
    }
}
