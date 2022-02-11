package Treee;

import java.util.*;

public class BinaryTree {

  static   TreeNode root;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

         TreeNode(int val) {
            this.val = val;
        }
    }

    public void createBinaryTree(){

        TreeNode first=new TreeNode(3);
        TreeNode second=new TreeNode(5);
        TreeNode third=new TreeNode(1);
        TreeNode fourth=new TreeNode(6);
        TreeNode fifth=new TreeNode(2);
        TreeNode sixth=new TreeNode(0);
        TreeNode seven=new TreeNode(7);
        TreeNode eight=new TreeNode(4);
        TreeNode nine=new TreeNode(8);

        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        second.right=fifth;
        fifth.left=seven;
        fifth.right=eight;
        third.right=nine;
        third.left=sixth;



    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currentLevel = 1;

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();

            // create a List<Integer> for which level and add all nodes to it in normal order
            while (size-- > 0) {
                TreeNode temp = q.poll();
                level.add(temp.val);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }

            // Now, just check if you are at a even level, and if so, reverse it
            if (currentLevel % 2 == 0) {
                Collections.reverse(level);
            }

            // Now just add the nodes from that level to result. And increment the level as you are going down
            res.add(level);
            currentLevel++;
        }
        return res;
    }

    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void preOrder(){
       if(root==null){
           return;
       }
       Stack<TreeNode> stack=new Stack<>();
       stack.push(root);
       while (!stack.isEmpty()){
           TreeNode temp=stack.pop();
           System.out.print(temp+" ");

           if(temp.right!=null){
               stack.push(temp.right);
           }
           if(temp.left!=null){
               stack.push(temp.left);
           }
       }

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null || root==p || root==q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                return root;
            }


    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<inorder.length;i+=1){
             map.put(inorder[i],i);
         }
         TreeNode root=findTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
return root;
    }

    private TreeNode findTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
   if(preStart>preEnd ||inStart>inEnd)return null;

   TreeNode root=new TreeNode(preorder[preStart]);
   int inPos=map.get(preorder[preStart]);
   int numsCount=inPos-inStart;
   root.left=findTree(preorder,preStart+1,preStart+numsCount,inorder,inStart,inPos-1,map);
   root.right=findTree(preorder,preStart+numsCount+1,preEnd,inorder,inPos+1,inEnd,map);
   return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //105. Construct Binary Tree from Preorder and Inorder Traversal
        //algorithm
        //put the inorder value in the map
        //if the preorder first value is the root
        //check the index root in inorder traversal
        //the left side of root is tree left side values
        //the right side of root is tree right side values
        //do it recursively
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);//take the root as preorder first value
        int inRoot = inMap.get(root.val);//get the index of the inorder root
        int numsLeft = inRoot - inStart;//get the how many values in the left ot right

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }


    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int  lh =dfs(root.left);
        int rh=dfs(root.right);

        if(lh==-1||rh==-1)return -1;

        if(Math.abs(rh-lh)>1) return -1;

        return Math.max(lh,rh)+1;
    }

    public static void main(String[] args) {
        BinaryTree b=new BinaryTree();
        b.createBinaryTree();

    }

}
