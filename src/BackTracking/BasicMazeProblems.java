package BackTracking;

import java.util.ArrayList;

public class BasicMazeProblems {
    public static void main(String[] args) {
        System.out.println( printPath(3,3,"",new ArrayList<>()));;
    }


    static int pathWays(int row,int col,int r,int c){
        if (r==3||c==3){

            return 1;
        }
     int left= pathWays(row,col,r+1,c);
     int right= pathWays(row,col,r,c+1);
       return left+right;

    }
   static ArrayList<String> printPath(int r,int c, String p,ArrayList<String>ans){
                 if (r==1&&c==1){
                    ans.add(p);
                     return ans;
                 }
                 if (r>1){
                     printPath(r-1,c,p+'D',ans);
                 }
                 if (c>1){
                     printPath(r,c-1,p+"R",ans);
                 }return ans;
   }
}
