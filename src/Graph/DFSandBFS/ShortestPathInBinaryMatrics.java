package Graph.DFSandBFS;

public class ShortestPathInBinaryMatrics {
    public static void main(String[] args) {
       //Input: grid = [[],[],[]]
        int[][]nums={{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(nums));
    }
    static int Mcount=Integer.MAX_VALUE;
    public static int shortestPathBinaryMatrix(int[][] grid) {
                return find(grid,0,0,0,grid[0][0]);
    }

    private static int find(int[][] grid, int count, int row, int column, int number) {
       if(row>=grid.length||column>=grid[0].length||grid[row][column]!=number){
           return count;
       }
       if (grid[row][column]== grid.length&&grid[row][column]== grid[0].length){
           Mcount=Math.min(Mcount,count);
           return Mcount;
       }
       find(grid,count+1,row+1,column,number);

        find(grid,count+1,row,column+1,number);

        find(grid,count+1,row+1,column+1,number);

        return Mcount;

    }
}
