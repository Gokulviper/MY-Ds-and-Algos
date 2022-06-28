package Treee.ReprsentationAndTraversals;



import java.util.*;

class MorrisTraversal {

    //use the thraded binary tree concept
    //if you go the left before mark the node the end of
    //subtree right node next connect the current head that easily we came back without recursion

    public List<Integer> inorderTraversal(BinaryTree.TreeNode root) {
        ArrayList < Integer > preorder = new ArrayList < > ();
        BinaryTree.TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.val);
                cur = cur.right;
            } else {
                BinaryTree.TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }

    }
