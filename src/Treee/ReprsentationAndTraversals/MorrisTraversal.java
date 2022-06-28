package Treee.ReprsentationAndTraversals;

import java.util.*;

class MorrisTraversal {
    //use the thraded binary tree concept
    //if you go the left before mark the node the end of
    //subtree right node next connect the current head that easily we came back without recursion

    public List<Integer> inorderTraversal(BinaryTree.TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        BinaryTree.TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {//left is null simle edge case
                //add the current node and point right
                inorder.add(cur.val); 
                cur = cur.right; 
            }
            else {//left is not null
                BinaryTree.TreeNode prev = cur.left;
                //go to the end of right some case we make threads so handle that
                //if you reach we prviously dont make thread
                //this reaches null check the prev is revisit the cur
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    //make the thread
                    prev.right = cur;
                    cur = cur.left; 
                }
                else {
                    //prev in the current mark it null
                    //and add to the ans
                    prev.right = null; 
                    inorder.add(cur.val); 
                    cur = cur.right; 
                }
            }
        }
        return inorder; 
    }
}