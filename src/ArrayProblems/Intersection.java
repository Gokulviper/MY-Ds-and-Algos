package ArrayProblems;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        //[]
        //[]
        int[]arr1={4,9,5};
        int[]arr2={9,4,9,8,4};
      int[]ans=  intersection(arr1,arr2);
        System.out.println(Arrays.toString(ans));

    }
    public static int[] intersection(int[] nums1, int[] nums2) {
       //this works for nums1 is greater length
        //size change this not works

        ArrayList<Integer> list=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i])>1){
                    list.add(nums2[i]);
                    map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);
                }
            }
        }
        int[]ans=new int[list.size()];
        for(int i=0;i<list.size();i+=1){
            ans[i]=(int)list.get(i);
        }
        return ans;

    }
}
