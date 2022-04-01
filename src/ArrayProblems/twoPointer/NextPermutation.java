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
        if(nums==null||nums.length<=1)return;
        int i=nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1])i--;
        if (i>=0){
            int j=nums.length-1;
            while (nums[j]<=nums[i])j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
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
