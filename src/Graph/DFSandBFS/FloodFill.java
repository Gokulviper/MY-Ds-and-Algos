package Graph.DFSandBFS;

public class FloodFill {
    public static void main(String[] args) {
        //Input: image = [[],[],[]],
        int[][]image={{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
      int[][]ans=  flooodFill(image,sr,sc,newColor);
      print2dArray(ans);

    }

    private static int[][] flooodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)return image;
        dfs(image,sr,sc,image[sr][sc],newColor);
        return image;

    }

    private static void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=color){
            return;
        }
        image[sr][sc]=newColor;
        dfs(image,sr+1,sc,color,newColor);
        dfs(image,sr-1,sc,color,newColor);
        dfs(image,sr,sc+1,color,newColor);
        dfs(image,sr,sc-1,color,newColor);

    }
    public static void print2dArray(int[][]nums){
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
}
