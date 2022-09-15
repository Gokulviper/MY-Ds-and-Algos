package Graph.MatrixProblems;


public class SrcToDest {
   static String ans="";
    public static void main(String[] args) {
        int[][] mat = new int[6][6];
        int i=5;
        int j=1;
        int row=0;
        int col=4;
        mat[i][j] = 1;
        mat[row][col] = 2;
        System.out.println(findUsingBactracking(mat, i, j, row, col));
        System.out.println(ans);
    }

    private static int findUsingBactracking(int[][] mat, int i, int j, int r, int c) {
        int distance = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        return findUsingBactrackingutil(mat, i, j, r, c, vis, distance, 0,"");

    }

    private static int findUsingBactrackingutil(int[][] mat, int i, int j, int r, int c, boolean[][] vis, int minDistacne, int distance,String path)
        {
            if (i == r && j == c) {
                if (minDistacne>distance){
                    ans=path;
                }
                minDistacne = Math.min(minDistacne, distance);
                return minDistacne;
            }
            vis[i][j] = true;
            if (isSafe(mat, vis, i + 1, j)) {
                minDistacne = Math.min(minDistacne, findUsingBactrackingutil(mat, i + 1, j, r, c, vis, minDistacne, distance+1,path+"("+i+","+j+")->"));
            }
            if (isSafe(mat, vis, i - 1, j)) {
                minDistacne = Math.min(minDistacne, findUsingBactrackingutil(mat, i - 1, j, r, c, vis, minDistacne, distance+1,path+"("+i+","+j+")->"));
            }
            if (isSafe(mat, vis, i, j - 1)) {
                minDistacne = Math.min(minDistacne, findUsingBactrackingutil(mat, i, j - 1, r, c, vis, minDistacne, distance+1,path+"("+i+","+j+")->"));
            }
            if (isSafe(mat, vis, i, j + 1)) {
                minDistacne = Math.min(minDistacne, findUsingBactrackingutil(mat, i, j + 1, r, c, vis, minDistacne, distance+1,path+"("+i+","+j+")->"));
            }
            vis[i][j]=false;
            return minDistacne;
        }


        private static boolean isSafe ( int[][] mat, boolean[][] vis, int i, int j){
            return i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && !vis[i][j];
        }

    }

