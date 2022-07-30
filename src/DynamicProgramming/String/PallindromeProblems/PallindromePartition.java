package DynamicProgramming.String.PallindromeProblems;

import java.util.*;

class PallindromePartition {
    public List<List<String>> partition(String s) {
        boolean[][]dp=new boolean[s.length()][s.length()];
      List<List<String>> ans=new ArrayList();
        f(s,0,ans,new ArrayList<>(),dp);
        return ans;
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