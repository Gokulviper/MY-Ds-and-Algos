package Treee.problems.BinaryTreeProblems;

import java.util.*;

class pair{
    TreeNode node;
    int num;
    pair(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
}
class MaximumWidthOfBinaryTree {
           public int widthOfBinaryTree(TreeNode root) {
               Queue<pair> q=new LinkedList();
               if(root==null){
                   return 0;
               }
               int ans=0;
               q.add(new pair(root,0));
               while(!q.isEmpty()){
                   int size=q.size();
                   int min=q.peek().num;
                   int first=0,last=0;
                   for(int i=0;i<size;i++){
                       int index=q.peek().num-min;
                       TreeNode temp=q.peek().node;
                       q.poll();
                       if(i==0)first=index;
                       if(i==size-1)last=index;
                       if(temp.left!=null)q.add(new pair(temp.left,index*2+1));
                       if(temp.right!=null)q.add(new pair(temp.right,index*2+2));
                   }
                   ans=Math.max(ans,last-first+1);
               }
               return ans;
           }
       }