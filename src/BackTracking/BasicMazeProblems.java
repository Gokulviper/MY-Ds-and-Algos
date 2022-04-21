package BackTracking;

public class BasicMazeProblems {
    public static void main(String[] args) {
      PrintPath(3,3,0,0,"");
    }
    static int pathWays(int row,int col,int r,int c){
        if (r==3||c==3){

            return 1;
        }
     int left= pathWays(row,col,r+1,c);
     int right= pathWays(row,col,r,c+1);
       return left+right;

    }
    static void PrintPath(int row,int col,int r,int c,String p){
        if (r==3||c==3){
            System.out.println(p);
            return ;
        }

         PrintPath(row,col,r+1,c,p+'D');
       PrintPath(row,col,r,c+1,p+'R');
       PrintPath(row, col, r+1, c+1, p+'D');


    }
}
