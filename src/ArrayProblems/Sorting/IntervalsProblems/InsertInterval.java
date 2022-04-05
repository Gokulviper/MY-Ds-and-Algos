package ArrayProblems.Sorting.IntervalsProblems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

    }
    private int[][]insertInterval(int[][]intervals,int[]newIntervals){
        List<int[]>ans=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        while (i<n&&intervals[i][1]<newIntervals[0]){
            i++;
        }
        for (int j = 0; j < i; j++) {
            ans.add(intervals[j]);
        }
        while (i<n&&intervals[i][0]<=newIntervals[1]){
            newIntervals[0]=Math.min(newIntervals[0],intervals[i][0] );
           newIntervals[1]=Math.max(newIntervals[1],intervals[i][1]);
           i++;
        }
        ans.add(newIntervals);
        while (i<n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
