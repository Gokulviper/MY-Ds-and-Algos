package BackTracking.Array;

import java.util.*;

class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
    public static List<List<Integer>> combine(int n, int k) {
           List ans=new ArrayList();
        List list =new ArrayList();
        sum(k,1,n,ans,list);
            return ans;
    }
    private static void sum(int k,int index,int n,List ans,List list){
        if(list.size()==k){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            sum(k,i+1,n,ans,list);
            list.remove(list.size()-1);
        }
    }
}