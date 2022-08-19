package ArrayProblems.Sorting.GeneralAlgorithms;



import java.util.Stack;

public class TT {
    public static void main(String[] args) {
        int[]nums={4,1,2,5,3};
        find(nums);
    }

    private static void find(int[] nums) {
         Stack<Integer> stack=new Stack();
         int val=1;
         int[]ans=new int[nums.length];
         int j=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==val){
                ans[j++]=val++;
            }else{
                stack.push(nums[i]);
            }
        }
        while (!stack.isEmpty()){
            ans[j++]=stack.pop();
        }
        for (int i = 0; i <ans.length-1 ; i++) {
            if (ans[i]>ans[i+1]){ System.out.print("No");
                return;
            }
        }
        System.out.println("yes");
    }
}
