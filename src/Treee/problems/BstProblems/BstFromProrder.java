package Treee.problems.BstProblems;

class BstFromProrder {
   TreeNode buildBST(int[] preorder,int bound,int i[])
   {
       if(i[0]==preorder.length||preorder[i[0]]>bound){
           return null;
          }
       
       TreeNode root=new TreeNode(preorder[i[0]++]);
       root.left=buildBST(preorder,root.val,i);
       root.right=buildBST(preorder,bound,i);
       return root;
   }
    public TreeNode bstFromPreorder(int[] preorder) {
     return  buildBST(preorder,Integer.MAX_VALUE,new int[1]);
    }
}