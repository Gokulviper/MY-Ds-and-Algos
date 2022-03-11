package ArrayProblems.BinarySearch;

class SearchInRotatedInSorted {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int pivot=pivot(nums);
        if (pivot==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if (target>=nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }
return binarySearch(nums,target,pivot+1,nums.length-1);
    }
    static int pivot(int[]nums){
        int start=0,end=nums.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (mid<end &&nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>start&&nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
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
    public int search1(int[] nums, int target) {
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                 ans=i;
                break;
            }
        }
       return ans;
    }
}