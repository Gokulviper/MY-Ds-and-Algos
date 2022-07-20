package BackTracking.String;

import java.util.ArrayList;
import java.util.List;

class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
          List<String> lst=new ArrayList<>();
        BackTrack(lst,s,new StringBuilder(),0,0);
        return lst;
    }
    void BackTrack(List<String> lst,String s,StringBuilder sb,int ind,int count)
    {
        // base condition no. of dots or count=3 and ind reached the last index of string
        
        if(ind==s.length() && count==3)
        {
            lst.add(sb.toString());
            return;
        }
        if(count>3) return;     // No.of dot limit exceeded
        
        for(int i=ind;i<s.length();i++)
        {
            String part=s.substring(ind,i+1);
            
            if(part.length()>1 && part.charAt(0)=='0'  || Integer.parseInt(part)>255) // If the base condition fails exit the loop
                break ;
            
            int len=sb.length();
            
            sb.append(part);
            
            // Backtracking
            
            // Last element is reached
            
            if(i+1==s.length())
                BackTrack(lst,s,sb,i+1,count);
                
            else    
            {
                sb.append('.');
                BackTrack(lst,s,sb,i+1,count+1);
                sb.setLength(len); // Delete the elements that get added in the recursion calls
            }
           
        } 
    }
}