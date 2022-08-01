package DynamicProgramming.Grid;
/*
The idea is to use dynamic programming and padding matrix to calculate how
many submatrices we can create at from each element matrix[i][j],
 using the element neighbours: pad[i-1][j],pad[i][j-1],pad[i-1][j-1] .
If matrix[i][j] == 0, we do nothng and move on.
if matrix[i][j] == 1, we check what is the minimum submatrices
square edge length we can built using the neighbours and adding it 1
for submatrices in size one which we can build with element matrix[i][j].
 */
class CountsquareSubmatrix {
    public int countSquares(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][]dp=new int[n+1][m+1];
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]==1){
               int num=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                dp[i][j]=1+num;
                ans+=dp[i][j];
            }
            }
        }
        return ans;
    }
}