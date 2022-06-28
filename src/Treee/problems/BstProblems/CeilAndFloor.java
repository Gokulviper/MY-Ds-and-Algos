package Treee.problems.BstProblems;

public class CeilAndFloor {
    public static void main(String[] args) {

    }
    int findCeil(TreeNode root,int val){
        int ceil=Integer.MAX_VALUE;
        if (root==null){
            return ceil;
        }
        if (root.val>val&&root.val<ceil){
            ceil=root.val;
        }
        if (root.val==val){
            return root.val;
        }else if (root.val>val){
            return  findCeil(root.left,val);
        }else{
            return findCeil(root.right,val);
        }

    }
    int findFloor(TreeNode root,int val){
        int floor=-1;
        while (root!=null){
            if (root.val==val){
                floor=root.val;
                return floor;
            }
            if (val>root.val){
                floor=root.val;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }
}
