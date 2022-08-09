package DynamicProgramming.Array;
/*
slice mean sequecnce of three numbers
so start the index 2
nums-> 1  2  3 -> nums[2]-nums[1]==nums[i]-nums[0]- put the bigger number first
 idx  --> 0  1  2
 */
class ArthmeticSlices {
    public static void main(String[] args) {

    }
    public int space(int[] nums) {
        int sum=0;
        int dp=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp=1+dp;
                sum+=dp;
            }else{
                dp=0;
            }
        }
        return sum;
    }
    public int numberOfArithmeticSlices(int[] nums) {
       int sum=0;
        int[]dp=new int[nums.length];
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=1+dp[i-1];
                sum+=dp[i];
            }
        }
        return sum;
    }
}