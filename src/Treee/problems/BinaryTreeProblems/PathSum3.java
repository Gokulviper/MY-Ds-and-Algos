package Treee.problems.BinaryTreeProblems;

import java.util.HashMap;
import java.util.Map;
class TreeNode1{
    int val;
    TreeNode1 left,right;
    TreeNode1(int data){
        this.val=data;

    }
}
class PathSum3 {
    // 1 1 1 2 2 3 4 5
    public static void main(String[] args) {
        TreeNode1 root=null;
        TreeNode1 t1=new TreeNode1(10);
        TreeNode1 t2=new TreeNode1(5);
        TreeNode1 t3=new TreeNode1(3);
        TreeNode1 t4=new TreeNode1(3);
        TreeNode1 t5=new TreeNode1(-2);
        TreeNode1 t6=new TreeNode1(2);
        TreeNode1 t7=new TreeNode1(1);
        TreeNode1 t8=new TreeNode1(-3);
        TreeNode1 t9=new TreeNode1(11);
        t1.left=t2;
        t2.left=t3;
        t3.left=t4;
        t2.right=t6;
        t6.right=t7;
        t3.right=t5;
        t1.right=t8;
        t8.right=t9;
     root=t1;
        System.out.println(pathSum(root,8));
    }

    private static int find(int[] nums) {
          int start=0,end=0;
        Map < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                if(i - map.get(count)>maxlen) {
                    maxlen = Math.max(maxlen, i - map.get(count));
                    start=map.get(count);
                    if (start==-1){
                        start++;
                    }
                    end=i;
                }
            } else {
                map.put(count, i);
            }
        }
        System.out.println(start);
        System.out.println(end);
        return maxlen;
    }

    public static int pathSum(TreeNode1 root, int targetSum) {
      Map<Integer,Integer> map=new HashMap();
        map.put(0,1);
      return  f(root,targetSum,0,map);
         
    }
  static int f(TreeNode1 root, int target, int sum, Map<Integer,Integer> map){
        int ans=0;
        if(root==null){
            return ans;
        }

       
       sum+=root.val;
        if(map.containsKey(sum-target)){
            ans+=map.get((sum-target));
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        ans+=f(root.left,target,sum,map);
        ans+=f(root.right,target,sum,map);
        map.put(sum,map.getOrDefault(sum,0)-1);
        return ans;
    }
}
