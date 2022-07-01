package Treee.problems.BstProblems;

import java.util.Stack;

class B{
    boolean reverse;
    Stack<TreeNode> stack=new Stack();
    B(TreeNode root,boolean isR){
        this.reverse=isR;
        pushAll(root);
    }
    int next(){
        TreeNode root= stack.pop();
        if(reverse){
            pushAll(root.left);
        }else{
            pushAll(root.right);
        }
        return root.val;
    }
    void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(reverse){

                root=root.right;
            }else{

                root=root.left;
            }
        }
    }
}
class TwoSumBst {
    public boolean findTarget(TreeNode root, int k) {
        B left=new B(root,false);
         B right=new B(root,true);
        int i=left.next();
        int j=right.next();
        while(i<j){
            if(i+j==k){
                return true;
            }else if(i+j<k){
                i=left.next();
            }else{
                j=right.next();
            }
        }
        return false;
    }
}