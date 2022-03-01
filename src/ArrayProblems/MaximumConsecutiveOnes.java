package ArrayProblems;

class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count=0;
                while(i<nums.length&&nums[i]==1){
                    count++;
                    i++;
                }
                i--;
            }
            max= Math.max(max,count);
        }
        return max;

    }
}