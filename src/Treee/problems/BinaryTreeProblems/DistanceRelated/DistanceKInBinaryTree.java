package Treee.problems.BinaryTreeProblems.DistanceRelated;



import java.util.*;

class DistanceKInBinaryTree {
    public List<Integer> distanceK(Node root, Node target, int k) {
         Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track);//after this method execution
        //the parent track is fiiled with all nodes and parents
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int dis = 0;
        while(!queue.isEmpty()) { /*Second BFS to go upto K level from target node and using our hashtable info*/
            int size = queue.size();
            if(dis == k) break;
            dis++;
            for(int i=0; i<size; i++) {
               Node temp = queue.poll();

                    if(temp.left != null && !visited.containsKey(temp.left)) {
                    //check is not null ans not visited
                    queue.offer(temp.left);

                    visited.put(temp.left, true);
                }
                if(temp.right != null && !visited.containsKey(temp.right)) {
                    queue.offer(temp.right);
                    visited.put(temp.right, true);
                }
                if(parent_track.containsKey(temp)  && !visited.containsKey(parent_track.get(temp)) ) {
                    queue.offer(parent_track.get(temp));
                    visited.put(parent_track.get(temp), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>(); 
        while(!queue.isEmpty()) {
           Node current = queue.poll();
            result.add(current.data);
        }
        return result;
    }
      private void markParents(Node root, Map<Node, Node> parent_track) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()) { 
            Node temp = queue.poll();
            if(temp.left != null) {
                parent_track.put(temp.left, temp);
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                parent_track.put(temp.right, temp);
                queue.offer(temp.right);
            }
        }
    }
}