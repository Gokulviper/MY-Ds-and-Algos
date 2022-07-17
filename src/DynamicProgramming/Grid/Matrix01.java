package DynamicProgramming.Grid;

import java.util.Arrays;

class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
      int n = mat.length,m=mat[0].length;
		int[][] ans = new int[n][m];
		for(int[] rows : ans){
			Arrays.fill(rows,Integer.MAX_VALUE/10);
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j]==1){
					if(i>0){
						ans[i][j]=Math.min(ans[i][j],ans[i-1][j]+1);
					}
					if(j>0){
						ans[i][j]=Math.min(ans[i][j],ans[i][j-1]+1);
					}
				}else ans[i][j]=0;
			}
		}

		for(int i=n-1;i>=0;i--){
			for(int j=m-1;j>=0;j--){
				if(i<n-1){
					ans[i][j]=Math.min(ans[i][j],ans[i+1][j]+1);
				}
				if(j<m-1){
					ans[i][j]=Math.min(ans[i][j],ans[i][j+1]+1);
				}
			}
		}
		return ans;
}
}