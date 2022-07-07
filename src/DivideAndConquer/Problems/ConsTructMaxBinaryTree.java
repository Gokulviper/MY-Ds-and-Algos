package DivideAndConquer.Problems;


class TreeNode{
    int data;
    TreeNode left,right;
    TreeNode(int data){
        this.data=data;
    }
}

public class ConsTructMaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      return build(nums,0,nums.length);
    }
    TreeNode build(int[]nums,int start,int end){
        if(start==end)return null;
        int max=find(nums,start,end);
        TreeNode root=new TreeNode(nums[max]);
        root.left=build(nums,start,max);
        root.right=build(nums,max+1,end);
        return root;
    }
    int find(int[]nums,int start,int end){
        int max=start;
        for(int i=start;i<end;i++){
          if(nums[i]>nums[max]){
              max=i;
          }
        }
        return max;
    }
}
