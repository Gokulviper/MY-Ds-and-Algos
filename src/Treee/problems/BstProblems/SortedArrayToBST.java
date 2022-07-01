package Treee.problems.BstProblems;

class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==1)return  new TreeNode(nums[0]);
       return build(nums,0,nums.length-1);
    }
    TreeNode build(int[]nums,int start,int end){
        if(start<=end){
            int mid=start+(end-start)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=build(nums,start,mid-1);
            root.right=build(nums,mid+1,end);
            return root;
        }
        return null;
    }
}