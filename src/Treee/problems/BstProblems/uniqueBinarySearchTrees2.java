package Treee.problems.BstProblems;

import java.util.ArrayList;
import java.util.List;

class uniqueBinarySearchTrees2 {
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
    public static List<TreeNode> generateTrees(int n) {
        return subTrees(1, n);
    }
    private static List<TreeNode> subTrees(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end) {
            res.add(null);
            return res;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> left = subTrees(start, i-1);
            List<TreeNode> right = subTrees(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
    
}