package Treee.problems.BinaryTreeProblems.DistanceRelated;


import java.util.*;
class Node
{

    public int data;
   Node left;
Node right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
public class BurningTheTreeMinimumTime
{
    private static Node markParents(Node root, Map<Node, Node> parent_track, int start) {
        Node ans=null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.data==start)ans=temp;
            if(temp.left != null) {
                parent_track.put(temp.left, temp);
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                parent_track.put(temp.right, temp);
                queue.offer(temp.right);
            }
        }
        return ans;
    }
    private static int findMaxDistance(HashMap<Node, Node> mpp, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        HashMap<Node,Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        
        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;
            
            for(int i = 0;i<sz;i++) {
                Node node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }
    public static int timeToBurnTree(Node root, int target)
    {
        HashMap<Node, Node> mpp = new HashMap<>();
        HashMap<Node, Node> parent_track=new HashMap<>();
        Node n=markParents(root,parent_track,target);
        int ans=findMaxDistance(parent_track,n);
      return ans;

    }
}