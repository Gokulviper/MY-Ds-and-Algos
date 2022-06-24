package Treee.problems.HeightRelaltedProblems;



class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return f(root)!=-1;
    }
    int f(TreeNode root){
        if(root==null)return 0;
        int lh=f(root.left);
        int rh=f(root.right);
        if(lh==-1||rh==-1)return -1;
        if(Math.abs(lh-rh)>1)return -1;
        return 1+Math.max(lh,rh);
    }
}