package Treee.binarySearchTree;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    static TreeNode root;
    static class TreeNode {
        int val;
       TreeNode left;
      TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public void createBinaryTree(){

   TreeNode first=new TreeNode(3);
      TreeNode second=new TreeNode(5);
    TreeNode third=new TreeNode(1);
        TreeNode fourth=new TreeNode(6);
       TreeNode fifth=new TreeNode(2);
      TreeNode sixth=new TreeNode(0);
      TreeNode seven=new TreeNode(7);
      TreeNode eight=new TreeNode(4);
      TreeNode nine=new TreeNode(8);

        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        second.right=fifth;
        fifth.left=seven;
        fifth.right=eight;
        third.right=nine;
        third.left=sixth;



    }

    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void preOrder(){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
         TreeNode temp=stack.pop();
            System.out.print(temp.val+" ");

            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
       TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }


    }
    public void levelOrder(){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
                queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.println(temp.val+" ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }


    public static void main(String[] args) {
        Treee.BinaryTree b=new Treee.BinaryTree();
        b.createBinaryTree();
        b.preOrder();

    }
}
