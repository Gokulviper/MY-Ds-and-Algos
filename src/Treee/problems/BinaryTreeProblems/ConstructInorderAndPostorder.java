package Treee.problems.BinaryTreeProblems;

import java.util.*;

class ConstructInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,postorder,0,n-1,0,n-1,map);
    }
    TreeNode build(int[]inorder, int[]postorder, int is, int ie, int ps, int pe, Map<Integer,Integer> map){
        if(ps>pe||is>ie)return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int inpos=map.get(postorder[pe]);
        int numsLeft=inpos-is;
        root.left=build(inorder,postorder,is,inpos-1,ps,ps+numsLeft-1,map);
        root.right=build(inorder,postorder,inpos+1,ie,ps+numsLeft,pe-1,map);
        return root;
    }
}