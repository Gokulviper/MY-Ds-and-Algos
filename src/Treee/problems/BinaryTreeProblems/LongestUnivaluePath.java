package Treee.problems.BinaryTreeProblems;

class LongestUnivaluePath {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        f(root);
        return ans;
    }
    public int f(TreeNode root) {
       if(root==null)return 0;
        int left=f(root.left);
        int right=f(root.right);
        int a=0,b=0;
        if(root.left!=null&&root.val==root.left.val){
            a+=left+1;
        }
        if(root.right!=null&&root.val==root.right.val){
            b+=right+1;
        }
        ans=Math.max(ans,a+b);
        return Math.max(a,b);
    }
}