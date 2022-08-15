package Treee.problems.BinaryTreeProblems;

class DIstributeCoins {
    int ans=0;
    public int distributeCoins(TreeNode root) {
        f(root);
        return ans;
    }
    int f(TreeNode root)
    {
        if(root==null)return 0;
        int left=f(root.left);
        int right=f(root.right);
        ans+=Math.abs(left)+Math.abs(right);
        return root.val+left+right-1;
    }
}