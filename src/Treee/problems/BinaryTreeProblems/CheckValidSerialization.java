package Treee.problems.BinaryTreeProblems;

import java.util.Stack;

class CheckValidSerialization {
    public boolean isValidSerialization(String preorder) {
        String[]s=preorder.split(",");
        Stack<String> stack=new Stack();
        for(int i=0;i<s.length-1;i++){
            if(s[i].equals("#")){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(s[i]);
            }
        }
        return stack.isEmpty()&&s[s.length-1].equals("#");
    }
}