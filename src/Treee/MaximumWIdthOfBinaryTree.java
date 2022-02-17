package Treee;

public class MaximumWIdthOfBinaryTree {
    /*

//algorithm
//first explanation why do this modified index approach
  --
    *we use  to solve indexing
    *so we maintain node as inside node type node value and the index
    *take the first index and last index
    *use the formula last-first+1
    *the given a skew tree the index go around integer Overflow

 //so the real idea is if the level is finished make next starting node as 0
 //using  take peek and minus by the peek
 //do every children finding  index*2+1 for left
 //index*2+2 for right
 //maintain max value and return





    class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;    //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().num-mmin;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null)
                    q.offer(new Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}






     */
}
