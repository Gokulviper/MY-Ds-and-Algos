package DynamicProgramming.Grid;

import java.util.Arrays;

public class MaximalSquare {
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
                max=Math.max(memoization1(nums,i,j),max);
            }
        }
        return max*max;
    }
    int memoization1(char[][]nums, int i, int j){
        if(i>=nums.length||j>=nums[0].length||nums[i][j]=='0')return 0;
        return 1+Math.min(Math.min(memoization1(nums,i+1,j), memoization1(nums,i,j+1)), memoization1(nums,i+1,j+1));
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