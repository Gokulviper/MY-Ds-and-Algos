package ArrayProblems.Sorting.IntervalsProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
     int[][]nums={{1,3},{2,6},{8,10},{15,18}};
     merge(nums);
    }
    public static int[][] merge(int[][]intervals){
        if (intervals.length<=1)return intervals;
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(nums1,nums2)->Integer.compare(nums1[0],nums2[0]));
        int[]current_Interval=intervals[0];
        ans.add(current_Interval);
        for (int[] interval:intervals){
            int current_end=current_Interval[1];
            int next_begin=interval[0];
            int next_end=interval[1];
            if (current_end>=next_begin){
                current_Interval[1]=Math.max(current_end,next_end);
            }
            else
            {
                current_Interval=interval;
                ans.add(current_Interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
