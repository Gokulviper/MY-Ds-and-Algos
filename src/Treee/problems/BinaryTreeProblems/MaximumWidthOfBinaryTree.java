package Treee.problems.BinaryTreeProblems;
/*algorithm
        /first explanation why do this modified index approach
        --
        *we use  to solve indexing
        *so we maintain node as inside node type node value and the index
        *take the first index and last index
        *use the formula last-first+1
        *the given a skew tree the index go around integer Overflow

//so the real idea is if the level is finished make next starting node as 0
//using  take peek and minus by the peek
//do every children finding  index*2+1 for left
//index*2+2 for right
//maintain max value and return   */
import java.util.*;
/*
inorder to avoid overflow maintain evrry level makes the every node makes the index
so we get the minimum of previous level take that mininum take the subract with current
node add that index 2*index+1
 */
class pair{
    Node node;
    int num;
    pair(Node node, int num){
        this.node=node;
        this.num=num;
    }
}
class MaximumWidthOfBinaryTree {
           public int widthOfBinaryTree(Node root) {
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
                       Node temp=q.peek().node;
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