package Graph.MatrixProblems;

import ArrayProblems.Sorting.GeneralAlgorithms.P;

import java.util.LinkedList;
import java.util.Queue;

class Point{
    int row,col;
    Point(int r,int c){
        row=r;
        col=c;
    }
}
class QueueNode{
    Point p;
    int dis;
    QueueNode(Point p,int d){
        this.p=p;
        dis=d;
    }
}
public class SrcToDisUsingBfs {
    public static void main(String[] args) {
        int[][] mat = new int[6][6];
        int i=5;
        int j=1;
        int row=0;
        int col=4;
        mat[i][j] = 1;
        mat[row][col] = 2;
        System.out.println( findShortestPath(mat,i,j,row,col));  ;
    }

    private static int findShortestPath(int[][] mat, int i, int j, int row, int col) {
        Queue<QueueNode>q=new LinkedList<>();
        boolean[][]vis=new boolean[mat.length][mat[0].length];
        vis[i][j]=true;
        q.add(new QueueNode(new Point(i,j),0));
        int[][]dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while (!q.isEmpty()){
            QueueNode qNode=q.poll();
            Point src=qNode.p;
            if (src.row==row&&src.col==col)return qNode.dis;
            for (int k = 0; k <4 ; k++) {
                int r=src.row+dir[1][0];
                int c=src.col+dir[0][1];
                if(r>=0&&c>=0&&r<mat.length&&c<mat[0].length&&!vis[r][c]){
                    vis[r][c]=true;
                    q.add(new QueueNode(new Point(r,c), qNode.dis+1));
                }
            }
        }
        return -1;
    }
}
