package Treee.problems.BstProblems;
class Node{
    Node left,right;
    int data;

        }
class InorderSucessor
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
         {
         if(root==null)return null;
         Node suc=null;
         while(root!=null){
             if(x.data>=root.data){
                 root=root.right;
             }else{
                 suc=root;
                 root=root.left;
             }
         }
         return suc;
         }
}