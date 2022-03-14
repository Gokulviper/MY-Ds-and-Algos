package ArrayProblems;

class TriangleNumber {
    public static void main(String[] args) {

    }
    public static int triangleNumber(int[] nums) {
        //brute force
        //time limit exceeded
       int count=0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]>nums[k]&&
                      nums[i]+nums[k]>nums[i]&&
                      nums[j]+nums[k]>nums[j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}