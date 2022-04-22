package BackTracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        int[][]nums={{1,1,1},
                {1,0,1},
                {1,1,1}};
        System.out.println( printPathWithObstacles(nums));;
    }

    private static ArrayList printPathWithObstacles(int[][] nums) {
        ArrayList<String >ans=new ArrayList<>();
        print("",nums,0,0,ans);
        return ans;
    }

    private static void print(String p, int[][] nums, int r, int c, ArrayList<String> ans) {
        if (r==nums.length-1&&c==nums[0].length-1){
            ans.add(p);
            return;
        }
        if (nums[r][c]==0){
            return;
        }
        if (r<nums.length-1&&c<nums[0].length-1){
            print(p+'D',nums,r+1,c+1,ans);

        }
        if (r<nums.length-1) {
            print(p + 'V', nums, r + 1, c, ans);
        }

        if (c<nums[0].length-1){
            print(p+'H',nums,r,c+1,ans);

        }
    }
}
