package Treee.problems.BinaryTreeProblems;

class InvertTree {
    public TreeNode invertTree(TreeNode root) {
     if(root==null)return null;
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode temp=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=temp;
        return root;
    }
}