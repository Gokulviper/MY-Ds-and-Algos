package Treee.ReprsentationAndTraversals;

import java.util.*;


public class BinaryTree {

  static   TreeNode root;
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
    void preOrder(TreeNode node){
        //this recursive approach
        if (node==null){
            return;
        }
        System.out.print(node.val+ " ");
        preOrder(node.left);
        preOrder(node.right);

    }
    void preOrder(){
        if (root==null)return;
        Stack<TreeNode> stack=new Stack();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode temp=stack.pop();
            System.out.print(temp.val+" ");
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);
            }
        }
    }
    void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    void inOrder(){
        if (root==null)return;
        Stack<TreeNode>stack=new Stack<>();
       TreeNode temp=root;
        while (!stack.isEmpty()||temp!=null){
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;///go to the end of the left side tree
            }else {
                temp=stack.pop();
                System.out.print(temp.val+" ");//after this reaches the null
                //then you go the right
                temp=temp.right;
            }
        }
    }
    void postOrder(TreeNode root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    void postOrder(){
        if (root==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
    }
    void levelOrder(){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.val+" ");
            if (temp.left!=null){
                queue.add(temp.left);
            }
            if (temp.right!=null){
                queue.add(temp.right);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree b=new BinaryTree();
        b.createBinaryTree();
      b.preOrder(root);
        System.out.println();
      b.preOrder();
        System.out.println();
                b.inOrder();
        System.out.println();
        b.inOrder(root);
        System.out.println();
        b.levelOrder();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        printPath(root,path,ans);
        System.out.println(ans);
    }

    private static void printPath(TreeNode root, List<Integer> path, List<List<Integer>> ans) {
        if (root==null){
            ans.add(path);
            return;
        }
        path.add(root.val);
        printPath(root.left,path,ans);
        path.remove(path.size()-1);
        path.add(root.val);
        printPath(root.right, path, ans);
        path.remove(path.size()-1);
     //   return;
    }

}
