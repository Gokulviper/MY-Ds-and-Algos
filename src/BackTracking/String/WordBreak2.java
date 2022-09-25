package BackTracking.String;

import java.util.*;

class WordBreak2 {
List list=new ArrayList<>();
public List wordBreak(String s, List wordDict) {
solve(0,s,wordDict,"");
return list;
}

void solve(int ind, String w, List<String> d, String s){
    if(ind==w.length()){
        s=s.substring(0,s.length()-1);
        list.add(s);
        return;
    }
    
    for (int i=ind;i<w.length();i++){
        if(d.contains(w.substring(ind,i+1))){               // take only when the substring matches the dictionary
            solve(i+1,w,d,s+w.substring(ind,i+1)+" ");     //if matches call the function again with the left over string 
        }
    }//for
    
}//solv
}