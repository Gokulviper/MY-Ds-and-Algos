package Treee.problems.BstProblems;

class TreeNode{
    static TreeNode root;
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
    }
}


class SearchInBSt {
    public TreeNode searchBST(TreeNode root, int val) {
         if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        else if(root.val<val){
          return  searchBST(root.right,val);
        }else{
          return  searchBST(root.left,val);
        }
    }
   
    
}