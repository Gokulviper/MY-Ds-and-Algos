package Treee.problems.BinaryTreeProblems;

import java.util.*;

public class LevelOrderZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList();
        if(root==null)return ans;
        Queue<Node> q=new LinkedList();
        q.add(root);
        int c=1;
        while(!q.isEmpty()){
            List<Integer> level=new ArrayList();
            int size=q.size();
            while(size-->0)
            {
                Node temp=q.poll();
                level.add(temp.val);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            if(c%2==0){
                Collections.reverse(level);
            }
            c++;
            ans.add(new ArrayList(level));
        }
        return ans;
    }
}
