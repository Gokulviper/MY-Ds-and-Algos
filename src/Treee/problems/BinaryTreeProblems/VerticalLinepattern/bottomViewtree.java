package Treee.problems.BinaryTreeProblems.VerticalLinepattern;

import java.util.*;
class  pair{
    int line;
    Node node;
    pair(Node node,int line){
        this.line=line;
        this.node=node;
    }
}
class bottomViewtree
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root)
    {
       ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()) {
            Node temp = q.peek().node;
            int line = q.peek().line;
            q.poll();
            map.put(line, temp.data);
            if(temp.left != null) {

                q.add(new pair(temp.left,line-1));
            }
            if(temp.right != null) {

                q.add(new pair(temp.right,line+1));
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
    }
}