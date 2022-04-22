package BackTracking;

import java.util.ArrayList;

public class MazeAllPaths {
    public static void main(String[] args) {

    }
    public static void allPath(int[][]nums, int r, int c, String p, ArrayList<String >ans){
        if (r==nums.length-1&&c==nums[0].length){
           ans.add(p);
            return;
        }

    }
}
