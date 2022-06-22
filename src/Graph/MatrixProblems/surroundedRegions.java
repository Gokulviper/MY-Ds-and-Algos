package Graph.MatrixProblems;

class surroundedRegions {

	//idea is the  region is connected to edge that not a valid we make al as X
	//so first make dfs call on 4 ege rows and colum if its connected to all
	//,make as so we can easily to change 1 as O and all unchaged O are valid change to X
	public void solve(char[][] board) {
		if(board.length==0)return ;
		int row=board.length,col=board[0].length;
		for(int i=0;i<col;i++){
			dfs(board,0,i);
			dfs(board,row-1,i);
		}
		for(int i=0;i<row;i++){
			dfs(board,i,0);
			dfs(board,i,col-1);
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]=='1'){
					board[i][j]='O';
				}else if(board[i][j]=='O'){
					board[i][j]='X';
				}
			}
		}

	}
	void dfs(char[][]nums,int row,int col){
		if(row<0||row>=nums.length||col<0||col>=nums[0].length||nums[row][col]!='O'){
			return;
		}
		nums[row][col]='1';
		dfs(nums,row+1,col);
		dfs(nums,row-1,col);
		dfs(nums,row,col+1);
		dfs(nums,row,col-1);
	}
}