package Treee.problems.HeightRelaltedProblems;



class DiameterOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(7/-2);
    }
  
    public int diameterOfBinaryTree(TreeNode root) {
        int[]nums=new int[1];
         f(root,nums);
        return nums[0];
    }
    int f(TreeNode root,int[]nums){
        if(root==null)return 0;
     int lh=f(root.left,nums);
        int rh=f(root.right,nums);
        nums[0]=Math.max(lh+rh,nums[0]);
        
        return 1+Math.max(lh,rh);
    }
}