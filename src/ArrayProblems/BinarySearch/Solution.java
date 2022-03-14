package ArrayProblems.BinarySearch;

class NegativeNumbersCount {
    public static void main(String[] args) {
        // grid = [[],[],],[]]
        int[][]gird={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(gird));

    }
    public static int countNegatives(int[][] grid) {
        int i=0,j=grid[0].length-1;
        int count=0;
        while(i<grid.length&&j>=0){
            if(grid[i][j]<0){
                count+=(grid.length-i);
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
    public int countNegatives1(int[][] grid) {
        int count=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]<0){
                        count++;
                    }
                }
            }
            return count;
        
    }
}