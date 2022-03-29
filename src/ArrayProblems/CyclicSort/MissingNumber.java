package ArrayProblems.CyclicSort;

public class MissingNumber {
    public static void main(String[] args) {
    int[]nums={3,0,1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        cyclicSort(nums);
        //main noted point is this problem index and first number is zero
        if(nums[0]!=0)return 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
    public static void cyclicSort(int[]nums){
        int i=0;
        while(i< nums.length){
     int correct =nums[i];
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
}
