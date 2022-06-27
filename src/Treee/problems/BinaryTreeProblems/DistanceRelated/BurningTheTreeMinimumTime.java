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
    private static int findMaxDistance(HashMap<Node, Node> parent_track, Node root      ) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        HashMap<Node,Boolean> visited = new HashMap<>();
        visited.put(root, true);
        int maxi = 0;
        
        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;
            
            for(int i = 0;i<sz;i++) {
                Node temp = q.poll();
                if(temp.left != null && !visited.containsKey(temp.left)) {
                    fl = 1;
                    visited.put(temp.left, true);
                    q.offer(temp.left);
                }
                if(temp.right != null && !visited.containsKey(temp.right)) {
                    fl = 1;
                    visited.put(temp.right, true);
                    q.offer(temp.right);
                }

                if(parent_track.containsKey(temp)  && !visited.containsKey(parent_track.get(temp)) ) {
                    //this for checking up so first the the current node in the parent map
                    //so check the visited not visit the parent so add the parent that is one of adjacent
                    fl = 1;
                    visited.put(parent_track.get(temp), true);
                    q.offer(parent_track.get(temp));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }
    public static int timeToBurnTree(Node root, int target)
    {

        HashMap<Node, Node> parent_track=new HashMap<>();
        Node n=markParents(root,parent_track,target);
        return  findMaxDistance(parent_track,n);


    }
}