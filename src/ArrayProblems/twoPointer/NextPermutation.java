package ArrayProblems.twoPointer;
//swap the pair having lowest weightage to get next greater sequence
//special cases:
//case1 :they give the decending array:sort the arrray
//case2:the array is sorted:swap the last 2 elements
//other cases :mixed array:swap only using the last asc subarray BEAUSE any element before it will higher weigtage
public class NextPermutation {
    public static void main(String[] args) {

    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = -1;
        //start from back and find increasing sequence
        //find first number which breaks descending order.
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                pivot = i-1;
                break;
            }
        }

        //if not found then reverse whole array to make it lowest(given condition)
        if(pivot==-1){
            reverse(nums,0,n-1);
            return;
        }

        //Again traverse from backward and find element > pivot
        //swap their position
        //Then Reverse array after pivot element
        //And you are done......
        for(int i=n-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                swap(nums,pivot,i);
                reverse(nums,pivot+1,n-1);
                return;
            }
        }

    }
    private void reverse(int[] nums, int start, int end ){
        while (start<end){
            swap(nums,start++,end--);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

}
