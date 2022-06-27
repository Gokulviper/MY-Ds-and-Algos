package Treee.problems.BinaryTreeProblems;

class CountCompleteTreeNodes {
    /*
    the complete tree find the hright formula is 2pow h -1 is the complete
    tree sub tree nodes
 finding formula so we check the both height is equal use
 the formula is not equal simple add 1 for current node and check another recursivly
     */
    public int countNodes(TreeNode root) {
        //the the left height and right is equal
        if(root==null)return 0;
        int lh=findlh(root.left);
        int rh=findrh(root.right);
        if(lh==rh)return ((2<<lh)-1);

        return 1+countNodes(root.left)+countNodes(root.right);
    }
    int findlh(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    int findrh(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodesbrute(TreeNode root) {
        //brute
        if(root==null)return 0;
        int count=0;
        count++;
        count=count+countNodesbrute(root.left);
           count=count+countNodesbrute(root.right);
        
        return count;
    }
}