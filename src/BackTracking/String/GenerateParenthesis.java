package BackTracking.String;

import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {
    public static void main(String[] args) {
        int n=3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String >ans=new ArrayList<>();
        arrange(n,ans,0,0,"");
        return ans;
    }

    private static void arrange(int n, List<String> ans, int open, int close, String p) {
        if (p.length()==n*2){
            ans.add(p);
            return;
        }
        if (open<n){
            arrange(n,ans,open+1,close,p+'(');
        }
        if (open>close){
            arrange(n,ans,open,close+1,p+')');
        }
    }
}