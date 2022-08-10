package DynamicProgramming.LIS;
/*
lis pattern
three cases must thing we the number is
case 1: current number > previous number

case 2: current number < previous number
case 3: current number == previous number
general idea;
  we make two array that contains increasing and decresing subsequece
	if we find the number is greater or smaller we check the dp array previous get the
	subsequence length
case1
    - we find the one upper number so we add the sequence to previous lower number
     next number add that subsequence how do we get simple get the previous index +1 for
		 decreassing[i-1] so you add that
case 2:
  same process for previous if you find lower number that number is sequcnece previous
	upper number sequence get increasing[i-1]+1
	 note: important is we maintain both array for every case beacuse we check the previous
	 so if you dont look that array element update with previous index
	 dp[i]=dp[i-1]
case 3:
this is equal we make nothing so simply update form previous

 */
public class wiggleSubsequence {
    public static void main(String[] args) {

    }
    public int wiggleMaxLengthLinerDp(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[]up=new int[nums.length];
        int[]down=new int[nums.length];
        down[0]=up[0]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                up[i]=down[i-1]+1;
                down[i]=down[i-1];
            }else if(nums[i]<nums[i-1]){
                down[i]=up[i-1]+1;
                up[i]=up[i-1];
            }else{
                up[i]= up[i-1];
                down[i]= down[i-1];
            }
        }
        return Math.max(down[nums.length-1],up[nums.length-1]);
    }
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

}