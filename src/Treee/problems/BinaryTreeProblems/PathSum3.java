package Treee.problems.BinaryTreeProblems;

import java.util.HashMap;
import java.util.Map;

class PathSum3 {
    // 1 1 1 2 2 3 4 5
    public static void main(String[] args) {
        int[]nums={1,0,0,1,0,1,1,1};
        System.out.println(find(nums));;
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

    public int pathSum(TreeNode root, int targetSum) {
      Map<Integer,Integer> map=new HashMap();
        map.put(0,1);
      return  f(root,targetSum,0,map);
         
    }
    int f(TreeNode root,int target,int sum,Map<Integer,Integer> map){
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
