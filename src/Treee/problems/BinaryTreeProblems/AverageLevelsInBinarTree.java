package Treee.problems.BinaryTreeProblems;

import java.util.*;

class AverageLevelsInBinarTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList();
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            double sum=0;
            int size=q.size();
            for(int i=0;i<size;i++){               
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            ans.add(sum/size);
        }
        return ans;
    }
}