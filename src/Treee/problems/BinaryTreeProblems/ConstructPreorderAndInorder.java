package Treee.problems.BinaryTreeProblems;

import java.util.*;

class ConstructPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap();
        int n=preorder.length;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n-1,0,n-1,map);
        
    }
    TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, Map<Integer,Integer>map){
        if(ps>pe||is>ie)return null;
        TreeNode root=new TreeNode(preorder[ps]);
        int ipos=map.get(preorder[ps]);
        int numsLeft=ipos-is;
        root.left=build(preorder,inorder,ps+1,ps+numsLeft,is,ipos-1,map);
        root.right=build(preorder,inorder,ps+numsLeft+1,pe,ipos+1,ie,map);
        return root;
    }
}