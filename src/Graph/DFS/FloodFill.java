package Graph.DFS;

public class FloodFill {
    public static void main(String[] args) {
        //Input: image = [[],[],[]],
        int[][]image={{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        flooodFill(image,sr,sc,newColor);
    }

    private static int[][] flooodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)return image;
        dfs(image,sr,sc,image[sr][sc],newColor);
        return image;

    }

    private static void dfs(int[][] image, int sr, int sc, int color, int newColor) {
    }
}
