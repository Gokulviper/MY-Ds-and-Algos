package Treee.problems.BinaryTreeProblems;

import java.util.ArrayList;

class Node
 {

    public int data;
    public Node left;
     public Node      right;
     public Node next;


     public Node(int d)
     {
         data = d;
         left = right = null;
     }
 }
class BoundryTraversal
{
	ArrayList<Integer> boundary(Node node)
	{
	      ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (!isLeaf(node)) ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
	}
	   static Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(Node root, ArrayList < Integer > res) {
        Node cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    static void addRightBoundary(Node root, ArrayList < Integer > res) {
        Node cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (!isLeaf(cur)) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    static void addLeaves(Node root, ArrayList < Integer > res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
}
