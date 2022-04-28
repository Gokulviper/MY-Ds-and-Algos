package ArrayProblems.CyclicSort;

public class MissingNumber {
    public static void main(String[] args) {
    int[]nums={2};

        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        cyclicSort(nums);
        //main noted point is this problem index and first number is zero
        for (int i = 0; i <nums.length ; i++) {
           if (nums[i]-1!=i){
               return i+1;
           }
        }
        return nums.length;
    }
    public static void cyclicSort(int[]nums){
        int i=0;
        while(i< nums.length){
     int correct =nums[i]-1;
            if(nums[i]<nums.length&&nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else i++;
        }
    }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    int MissingNumber(int nums[], int n) {
        int a=(n*(n+1)/2);
        int t=0;
        for(int num:nums){
            t+=num;
        }
        return Math.abs(t-a);
    }
}
