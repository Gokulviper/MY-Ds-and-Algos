package Treee.problems.BinaryTreeProblems;

class CountGoodNodes {
    int ans=0;
    public int goodNodes(TreeNode root) {
        if(root==null)return 0;
        f(root,Integer.MIN_VALUE);
        return ans;
    }
    void f(TreeNode root,int max){
        if(root==null)return;
        if(root.val>=max)ans++;
        max=Math.max(root.val,max);
        f(root.left,max);
        f(root.right,max);
    }
}