package Treee.problems.BinaryTreeProblems;

import java.util.*;

class RightViewAndLeftView {
    public List<Integer> rightSideView(Node root) {
        List<Integer> ans=new ArrayList();
        r(root,ans,0);
        return ans;
    }
    void r(Node root, List<Integer> ans, int level){
        if(root==null)return ;
         if(ans.size()==level){
             ans.add(root.val);
         }
        r(root.right,ans,level+1);
        r(root.left,ans,level+1);
    }
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        f(root,ans,0);
        return ans;
    }
    void f(Node root, ArrayList<Integer> ans, int l){
        if(root==null)return ;
        if(ans.size()==l){
            ans.add(root.data);
        }
        f(root.left,ans,l+1);
        f(root.right,ans,l+1);
    }
}