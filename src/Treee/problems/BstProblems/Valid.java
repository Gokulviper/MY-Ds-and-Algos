package Treee.problems.BstProblems;

class Valid {
public boolean isValidBST(TreeNode root) {
return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
}
boolean valid(TreeNode root,Long min,Long max){
if(root==null){
return true;
}
if(root.val<=min||root.val>=max){
return false;
}
return valid(root.left,min,(long)root.val)&&valid(root.right,(long)root.val,max);
}
}