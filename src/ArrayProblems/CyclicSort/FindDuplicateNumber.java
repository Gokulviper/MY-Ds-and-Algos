package ArrayProblems.CyclicSort;

class FindDuplicateNumber {
    public static void main(String[] args) {
   int[]nums={1,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
    public static   int findDuplicate(int[] nums) {
        sort(nums);
        //1,2,2,4,4
        for (int i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                return nums[i];
            }
        }
        return -1;
    }
   static void  sort(int[]nums){
        int i=0;
        while (i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else i++;
        }
    }
  static   void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}