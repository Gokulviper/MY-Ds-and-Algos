package Treee.problems.BstProblems;

import java.util.Stack;
//algorithm
//solve this problem using iterative inorder traversal
//first push all left elements in the global stack
//if the stack is empty send the hasNext function is false
//if the  next function is called go the all right side elements
class BSTIterator {
Stack<TreeNode> stack=new Stack();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp=stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void pushAll(TreeNode root){
        while(root!=null){
            stack.add(root);
            root=root.left;
        }
    }
}