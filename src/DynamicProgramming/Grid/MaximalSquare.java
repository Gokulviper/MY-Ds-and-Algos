package DynamicProgramming.Grid;

import java.util.Arrays;
/*
the general idea is [ 0 1 1 1
																1 1 1 1
																0  1 11 ] simplye traverse the 3 ways
											right==down== diagonal
											three given right answer thats true
		but that makes three call for every time that makes lot time to run

	the idea is check the deptn first search find the min of three methods
	  this case [ 0 0 1
											1 11]
											this case we at the index mat[1][2] the check the diagonal backword
											that is zero the minimum of this call is 1 that why we can get the min
						if we get 2 so the square is 2*2 =4 total length
*/
public class MaximalSquare {
    public static void main(String[] args) {
        System.out.println(('A'-'A')+1);
    }
    public int tabulation(char[][] nums) {
        int[][]dp=new int[nums.length+1][nums[0].length+1];
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=nums[0].length-1;j>=0;j--){
                if(nums[i][j]=='1'){
                    dp[i][j]=1+Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1]);
                    max=Math.max(max,dp[i][j]);
                }
            }
        }

        return max*max;
    }
    public int maximalSquareMemo(char[][] nums) {
        int[][]dp=new int[nums.length][nums[0].length];
        for(int r[]:dp) Arrays.fill(r,-1);
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                max=Math.max(memoization(nums,i,j,dp),max);
            }
        }
        return max*max;
    }
    int memoization(char[][]nums, int i, int j, int[][]dp){
        if(i>=nums.length||j>=nums[0].length||nums[i][j]=='0')return 0;
        if(dp[i][j]==-1){
            dp[i][j]=1+Math.min(Math.min(memoization(nums,i+1,j,dp), memoization(nums,i,j+1,dp)), memoization(nums,i+1,j+1,dp));
        }
        return dp[i][j];
    }
    public int maximalSquareRecursion(char[][] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                max=Math.max(f(nums,i,j),max);
            }
        }
        return max*max;
    }
    int f(char[][]nums, int i, int j){
        if(i>=nums.length||j>=nums[0].length||nums[i][j]=='0')return 0;
        return 1+Math.min(Math.min(f(nums,i+1,j), f(nums,i,j+1)), f(nums,i+1,j+1));
    }
    public int maximalSquareBrute(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}