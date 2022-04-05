package ArrayProblems.Sorting.IntervalsProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
     int[][]nums={{1,3},{2,6},{8,10},{15,18}};
     merge(nums);
    }
    public static int[][] merge(int[][]nums){
       List<int[]>ans=new ArrayList<>();
       Arrays.sort(nums,(a,b)->a[0]-b[0]);
       int start=nums[0][0],end=nums[0][1];
        for (int j = 0; j <nums.length ; j++) {
            if (nums[j][0]<=end){
                end=Math.max(end,nums[j][1]);
            }else {
                ans.add(new int[]{start,end});
                start=nums[j][0];
                end=nums[j][1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
