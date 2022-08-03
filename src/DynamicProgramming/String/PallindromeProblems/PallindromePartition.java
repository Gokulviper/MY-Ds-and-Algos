package DynamicProgramming.String.PallindromeProblems;

import java.util.*;

class PallindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }
    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()) result.add(new ArrayList<String>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
   void f(String s,int start,List<List<String>> ans,List<String> list,boolean[][]dp){
       if(start>=s.length()){
           ans.add(new ArrayList(list));
       }
       for(int i=start;i<s.length();i++){
           if(s.charAt(i)==s.charAt(start)&&(i-start<=2||dp[start+1][i-1])){
               dp[start][i]=true;
               list.add(s.substring(start,i+1));
               f(s,i+1,ans,list,dp);
               list.remove(list.size()-1);
           }
       }
   }
  
}