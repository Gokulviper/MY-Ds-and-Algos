package Treee.ReprsentationAndTraversals;

import java.util.*;

class MorrisTraversal {
    public List<Integer> inorderTraversal(BinaryTree.TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        
        BinaryTree.TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {
                inorder.add(cur.val); 
                cur = cur.right; 
            }
            else {
                BinaryTree.TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left; 
                }
                else {
                    prev.right = null; 
                    inorder.add(cur.val); 
                    cur = cur.right; 
                }
            }
        }
        return inorder; 
    }
}