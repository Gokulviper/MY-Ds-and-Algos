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
             //find the next greater in the x.val
         if(root==null)return null;
         Node suc=null;
         while(root!=null){

             if(x.data>=root.data){
                 root=root.right;
                 //if its smaller need to go right
             }else{
                 //else make the ans but this not ans answer in more childrent in the left
                 //so we go left till reach the null
                 suc=root;
                 root=root.left;
             }
         }
         return suc;
         }
}