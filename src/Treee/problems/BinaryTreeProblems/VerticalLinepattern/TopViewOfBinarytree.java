package Treee.problems.BinaryTreeProblems.VerticalLinepattern;


import java.util.*;
class Node
{
    int data;
   Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
class Pair{
    int line;
    Node node;
    Pair(Node node,int hd){
        this.line =hd;
        this.node=node;
    }
}
class TopViewOfBinarytree
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
       ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
            Pair node = q.remove();
            int line = node.line;
            Node temp = node.node;
            if(!map.containsKey(line) ) map.put(line, temp.data);
            if(temp.left != null) {
                q.add(new Pair(temp.left, line - 1));
            }
            if(temp.right != null) {
                q.add(new Pair(temp.right, line + 1));
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
}