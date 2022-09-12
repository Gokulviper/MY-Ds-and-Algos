package Graph.MatrixProblems;


import java.util.LinkedList;
import java.util.Queue;

class Node{
    int row;
    int col;
    Node(int row,int col){
        this.row=row;
        this.col=col;
    }
}
public class SrcToDest {
    public static void main(String[] args) {
      int[][]mat=new int[6][6];
      mat[2][3]=1;
      mat[5][2]=2;
        System.out.println(find(mat,2,3));
    }

    private static int find(int[][] mat, int row, int col) {
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(row,col));
        int level=0;
        while (!q.isEmpty()){
            int size=q.size();
            while (size-->0) {
                Node node = q.poll();
                int i=node.row;
                int j=node.col;

            }
        }
        return 0;

    }
}
