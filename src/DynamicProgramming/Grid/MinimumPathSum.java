package DynamicProgramming.Grid;

class MinimumPathSum {
    public static void main(String[] args) {
        int[][]nums={{1,3,1},{1,5,1},{4,2,1}};
        int[][]dp=new int[nums.length][nums[0].length];
        System.out.println(minPathSum(nums,nums.length-1,nums[0].length-1));
    }

    private static int minPathSum(int[][]nums,int row,int col){
        if(row==0&&col==0)return nums[row][col];
        if(row<0||col<0)return Integer.MAX_VALUE;
        
       return nums[row][col]+Math.min(minPathSum(nums,row-1,col),minPathSum(nums,row,col-1));
    }
}