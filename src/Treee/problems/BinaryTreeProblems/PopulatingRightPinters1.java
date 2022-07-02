package Treee.problems.BinaryTreeProblems;

class PopulatingRightPinters1 {
    public Node connect(Node root) {
        if(root==null||root.left==null||root.right==null)return root;
        root.left.next=root.right;
        if(root.next!=null){
            root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}