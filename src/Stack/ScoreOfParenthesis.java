package Stack;

import java.util.Stack;

public class ScoreOfParenthesis {
    public static void main(String[] args) {
      String s="(())";
        System.out.println(scoreOfParentheses2(s));
    }
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack();
        int score=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(score);
                score=0;
            }else{
                score=stack.pop()+Math.max(2*score,1);
            }
        }
        return score;
    }
    public  static int scoreOfParentheses2(String S) {
        //space optimized
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;

            }
        }

        return ans;
    }
}
