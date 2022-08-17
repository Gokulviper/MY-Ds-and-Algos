package Treee.problems.BinaryTreeProblems;

class DeppestLeavesSum {
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)return 0;
        int maxDepth=depth(root);
        f(root,0,maxDepth-1);
        return sum;
    }
    int depth(TreeNode root){
        if(root==null)return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        return 1+Math.max(left,right);
    }
    void f(TreeNode root,int depth,int maxDepth){
        if(root==null)return;
        if(depth==maxDepth){
            sum+=root.val;
        }
        f(root.left,depth+1,maxDepth);
        f(root.right,depth+1,maxDepth);
    }
}