package String.HashinG;

import java.util.*;

class PartitionLables {
    public static void main(String[] args) {
        String  s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
    public static List<Integer> partitionLabels(String s) {
        int[]last_index=new int[26];
        for (int i=0;i<s.length();i++){
            last_index[s.charAt(i)-'a']=i;
        }
        List<Integer>ans=new ArrayList<>();
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
            end=Math.max(end,s.charAt(i)-'a');
        }
        return ans;
    }
}   