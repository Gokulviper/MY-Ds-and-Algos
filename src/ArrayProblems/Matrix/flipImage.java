package ArrayProblems.Matrix;

public class flipImage {
    public static void main(String[] args) {
        // [[],[],[]
        int[][]image={{1,1,0},{1,0,1},{0,0,0}};
   int[][]ans=    flipAndInvertImage(image);

print(ans);

    }
    public static int[][] flipAndInvertImage(int[][] image) {
        int[][]ans=new int[image.length][image[0].length];
        int k=0;
        for(int i=0;i<image.length;i++){
            for(int j=image[0].length-1;j>=0;j--){
                ans[i][k++]=image[i][j];
            }
            k=0;
        }
        for(int i=0;i<ans.length;i++){
            for (int j=0;j<ans[0].length;j++){
                ans[i][j]=1-ans[i][j];
            }
        }
        return ans;

    }
 static    void print(int[][]nums){
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
}
