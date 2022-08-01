package Treee.problems.BinaryTreeProblems;

class IsSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if(root==null||subRoot==null)return false;
         if (find(root,subRoot))return true;
         return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    private boolean find(TreeNode root, TreeNode subRoot) {
        if (root==null&&subRoot==null)return true;
        if (root==null||subRoot==null)return false;
        if (root.val!=subRoot.val)return false;
        return find(root.left,subRoot.left)&&find(root.right,subRoot.right);
    }
}