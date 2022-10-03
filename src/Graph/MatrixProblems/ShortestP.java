package Graph.MatrixProblems;

public class ShortestP {
    static String as="";
    public static void main(String[] args) {
        int[][]mat=new int[7][7];
        int cr=2;
        int cc=3;
        int tr=5;
        int tc=5;

        boolean[][]vis=new boolean[7][7];
int a= b(mat,cr,cc,tr,tc,Integer.MAX_VALUE,0,"",vis);
        System.out.println(a);
        System.out.println(as);
    }

    private static int b(int[][] mat, int i, int j, int tr, int tc, int minDis, int dis, String p, boolean[][] vis) {
   if (i==tr&&j==tc){
       if (minDis>dis){
           as=p;
       }
       minDis=Math.min(minDis,dis);
       return minDis;
   }
   vis[i][j]=true;
        if (safe(mat,i+1,j,vis)){
            minDis=Math.max(minDis,b(mat,i+1,j,tr,tc,minDis,dis+1,p+"("+i+","+j+")->",vis));
        }
   if (safe(mat,i-1,j,vis)){
       minDis=Math.max(minDis,b(mat,i-1,j,tr,tc,minDis,dis+1,p+"("+i+","+j+")->",vis));
   }
        if (safe(mat,i,j+1,vis)){
            minDis=Math.max(minDis,b(mat,i,j+1,tr,tc,minDis,dis+1,p+"("+i+","+j+")->",vis));
        }
        if (safe(mat,i,j-1,vis)){
            minDis=Math.max(minDis,b(mat,i,j-1,tr,tc,minDis,dis+1,p+"("+i+","+j+")->",vis));
        }

        vis[i][j]=false;
        return minDis;
    }

    private static boolean safe(int[][] mat, int i, int j, boolean[][] vis) {
        return i>=0&&j>=0&&i<mat.length&&j<mat[0].length&&!vis[i][j];
    }
}
