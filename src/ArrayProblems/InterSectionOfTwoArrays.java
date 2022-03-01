package ArrayProblems;

import java.util.*;

class InterSectionOfTwoArrays {
    public static void main(String[] args) {
        // nums1 = [1,2,2,1], nums2 = [2,2]
        int[]nums1= {4,9,11}, nums2 = {2,5,7,9};
        int[]ans=intersect1(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans=new ArrayList();
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i])>0){
                    ans.add(nums2[i]);
                    map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);
                }
            }
        }
        int[]res=new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ans.get(i);
            
        }
        return res;
        
    }
    public static int[] intersect1(int[] nums1, int[] nums2) {
        //both arrays are sorted
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0,j=0;
       while (i< nums1.length&&j< nums2.length){
           if (nums1[i]==nums2[j]){
               ans.add(nums2[j]);
               i++;
               j++;
           }else if(nums1[i]>nums2[j]){
               j++;
           }else if(nums1[i]<nums2[j]){
               i++;
           }
       }
       int []res=new int[ans.size()];
       for (int k=0;k<ans.size();k++){
           res[k]=ans.get(k);
       }
       return res;
    }
}