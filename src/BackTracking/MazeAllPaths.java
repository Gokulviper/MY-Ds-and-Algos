package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class MazeAllPaths {
    public static void main(String[] args) {
        int[][]nums={{1,1,1},
                {1,1,1},
                {1,1,1}};
        ArrayList<String>ans=new ArrayList<>();
        allPath(nums,0,0,"",  ans);
        System.out.println(ans);
    }
    public static void allPath(int[][]nums, int r, int c, String p, ArrayList<String >ans){
        if (r==nums.length-1&&c==nums[0].length-1){
           ans.add(p);
            return;
        }
        if (nums[r][c]==0){
            return;
        }
        nums[r][c]=0;
        if (r<nums.length-1&&c<nums[0].length-1){
            allPath(nums,r+1,c+1,p+'D',ans);
        }
        if (r<nums.length-1){
            allPath(nums,r+1,c,p+'V',ans);
        }
        if (c<nums[0].length-1){
            allPath(nums,r,c+1,p+'H',ans);
        }
        if (r>0){
            allPath(nums,r-1,c,p+'U',ans);
        }
        if (c>0){
            allPath(nums,r,c-1,p+'L',ans);
        }
        nums[r][c]=1;

    }
}
