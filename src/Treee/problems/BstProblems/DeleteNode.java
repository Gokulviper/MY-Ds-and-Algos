package Treee.problems.BstProblems;

class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(root.val==key){
            return helper(root);
        }
        TreeNode temp=root;
        while(root!=null){
            if(root.val<key){
                if(root.right!=null&&root.right.val==key){
                root.right=helper(root.right);
                    
                break;
                }else{
                    root=root.right;
                }
            }else{
              if(root.left!=null&&root.left.val==key){
                  root.left=helper(root.left);
                  break;
              }else{
                  root=root.left;
              } 
            }
        }
        return temp;
    }
    TreeNode helper(TreeNode root){
        if(root.left==null)return root.right;
        if(root.right==null)return root.left;
        TreeNode rightc=root.right;
        TreeNode last=find(root.left);
        last.right=rightc;
        return root.left;
    }
    TreeNode find(TreeNode root){
        if(root.right==null){
            return root;
        }
        return find(root.right);
    }
}