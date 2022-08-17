package Treee.problems.BinaryTreeProblems;

class IncreasingBst {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
     TreeNode    ans=new TreeNode(-1);
        cur=ans;
        f(root);
        return ans.right;
    }
   void f(TreeNode root){
        if(root==null)return ;
        f(root.left);
     
       root.left=null;
        cur.right=root;
        cur=root;
        f(root.right);
    }
}