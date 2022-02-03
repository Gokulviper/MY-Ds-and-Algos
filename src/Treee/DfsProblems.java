package Treee;

public class DfsProblems {
    int ans=0;
    public int sumNumbers(BinaryTree.TreeNode root) {

        dfs(root,0);
        return ans;

    }
    private void  dfs(BinaryTree.TreeNode root, int sum){
        if(root==null){
            return;
        }

        sum=(sum*10)+root.val;

        if(root.left==null&&root.right==null){
            ans+=sum;
        }

        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
