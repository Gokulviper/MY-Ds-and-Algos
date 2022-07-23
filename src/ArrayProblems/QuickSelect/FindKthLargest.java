package ArrayProblems.QuickSelect;

class FindKthLargest {
    public static void main(String[] args) {
            int[]nums={2,1,5,6,7,3,8,11,5,56};
        System.out.println(findKthLargest(nums,3));

    }
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        if (low==high){
             return nums[low];
        }
        int pivot=nums[high];
        int pivotIndex=partition(nums,pivot,low,high);
        if (pivotIndex==k){
            return pivot;
        }else  if(k<pivotIndex){
            return quickSelect(nums, low, pivotIndex-1, k);
        }else{
            return quickSelect(nums,pivotIndex+1,high,k);
        }

    }

    private static int partition(int[] nums, int pivot, int low, int high) {
         int i=low,j=low;
         while (i<=high){
             if (nums[i]<=pivot){
                 swap(nums,i,j);
                 i++;
                 j++;
             }else{
                 i++;
             }
         }
         return j-1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

}