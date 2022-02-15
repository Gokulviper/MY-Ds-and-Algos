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
    //173. Binary Search Tree Iterator
    private Stack<TreeNode> stack = new Stack<TreeNode>();
  //  public BSTIterator(TreeNode root) {
   //     pushAll(root);
//    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //algorithm
        //do level order traversal
        //if add a string in and aa space
        //this space can be  used split the deserialize
        //null be noted at n and also space
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");

            }else
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //algoithm
        //using regax to convert the string to array
        //using level order traversal
        //create treeNode the point the next values
        //ignore the string is "n"
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i=1; i<values.length; i++) {
            TreeNode node = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            i++;
            if (!values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        //we cannot pass  the variable because primitive data types stores
        //stack memory so i use array
        //tc:O(n)
        //sc:O(n)
        int[] nums=new int[1];
        findMax(root,nums);
        return nums[0];
    }
    private int findMax(TreeNode root,int[] nums){
        if(root==null){
            return 0;
        }
        int lh=findMax(root.left,nums);
        int rh=findMax(root.right,nums);
        nums[0]=Math.max(nums[0],lh+rh);

        return Math.max(lh,rh)+1;
    }

    public int findBottomLeftValue(TreeNode root) {
       // 513. Find Bottom Left Tree Value
        //algorithm
        //we can add the value opposite of level order
        //so the last root value is the longest value

        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            root=q.poll();
            if(root.right!=null){
                q.add(root.right);
            }
            if(root.left!=null){
                q.add(root.left);
            }
        }
        return root.val;
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
    public TreeNode deleteNode(TreeNode root, int key) {
        //450. Delete Node in a BST
        //algorithm
        //first find the key
        //take the right side of the root
        //and find root.left --> last right value
        //because all the right value should greater then the last right value
        //and the connect the  value
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {                                  //first check the element is exist or not
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null){
            return root.left;
        } else {
            TreeNode rightChild = root.right;  //take the right part
            TreeNode lastRight = findLastRight(root.left);//find the left last right value
            lastRight.right = rightChild;               //connect to right part

            return root.left;
        }
    }
    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
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
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsLeftLength=inRoot-is;
        root.left   = buildTreePostIn(inorder, is, inRoot-1, postorder, ps, ps+numsLeftLength-1, hm);
        root.right   = buildTreePostIn(inorder,inRoot+1, ie, postorder, ps+numsLeftLength, pe-1, hm);

        return root;
    }
    public TreeNode buildTree22(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer,Integer> map=new HashMap();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return find(postorder,0,n-1,inorder,0,n-1,map);
    }

    private TreeNode find(int[] postorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps>pe||is>ie)return null;

        TreeNode root=new TreeNode(postorder[pe]);
        int inRoot=map.get(root.val);
        int numsLeftLength=inRoot-is;
        root.left=find(postorder,ps,ps+numsLeftLength-1,inorder,is,inRoot-1,map);
        root.right=find(postorder,ps+numsLeftLength,pe-1,inorder,inRoot+1,ie,map);
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
