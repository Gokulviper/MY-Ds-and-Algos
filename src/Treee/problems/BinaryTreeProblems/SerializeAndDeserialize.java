package Treee.problems.BinaryTreeProblems;

import java.util.*;

public class SerializeAndDeserialize {
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null){
            return sb.toString();
        }
        Queue<TreeNode> q=new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode temp=q.poll();
           if(temp==null){
               sb.append('n'+" ");
               continue;
           }else{
               sb.append(temp.val+" ");
           }
            q.add(temp.left);
            q.add(temp.right);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
