package Treee.problems.BinaryTreeProblems;

class LowestCommonAncester {
    //simple inorder traversal you find the p or q return
    // that node other if you not find the any node return left or
    // right and you find the both the return current node
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
           return null;
        }
        if(root==p||root==q)return root;
          TreeNode l=lowestCommonAncestor(root.left,p,q);
            TreeNode r=lowestCommonAncestor(root.right,p,q);      
   if(l==null){
       return r;
   }else if(r==null){
       return l;
   }else{
       return root;
   }
      //  return null;
    }
}