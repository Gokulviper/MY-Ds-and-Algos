package BackTracking.String;

import java.util.*;

class PallindromePartionting {
    public List<List<String>> partition(String s) {
      List<List<String>> ans=new ArrayList();
        f(s,0,ans,new ArrayList<>());
        return ans;
    }
   void f(String s,int start,List<List<String>> ans,List<String> list){
       if(start>=s.length()){
           ans.add(new ArrayList(list));
       }
       for(int i=start;i<s.length();i++){
           if(pal(s,start,i)){
               list.add(s.substring(start,i+1));
               f(s,i+1,ans,list);
               list.remove(list.size()-1);
           }
       }
   }
    boolean pal(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}