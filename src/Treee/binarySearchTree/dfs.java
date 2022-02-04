package Treee.binarySearchTree;


public class dfs {
    public static void main(String[] args) {

    }

    int findMinValue(BinaryTree.TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;


        }

        return minValue;
    }

    public BinaryTree.TreeNode deleteNode(BinaryTree.TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key == root.val) {
            //case-1 & 2: single or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // if node has two children then find min value in right subtree
            // copy the min value with the current node
            // delete the node with min value in right sub tree
            root.val = findMinValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }
}
