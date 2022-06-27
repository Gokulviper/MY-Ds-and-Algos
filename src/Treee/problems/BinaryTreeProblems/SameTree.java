package Treee.problems.BinaryTreeProblems;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
    }
        }

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       
        if(p== null &&q == null)return true;
        if(p==null||q==null)return false;
             if(p.val!=q.val)return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}