package Treee.problems.BinaryTreeProblems;

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return false;
        return f(root.left,root.right);
            
        }
       boolean f(TreeNode node1,TreeNode node2){
          if(node1==null&&node2==null)return true;
           if(node1==null||node2==null)return false;
           if(node1.val!=node2.val){
               return false;
           }
           return f(node1.left,node2.right)&&f(node1.right,node2.left);
       }
    }