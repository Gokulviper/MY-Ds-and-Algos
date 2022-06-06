package ArrayProblems.Sorting.IntervalsProblems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

    }
    private int[][]insertInterval(int[][]intervals,int[]newInterval){
      List<int[]>ans=new ArrayList<>();
      int i=0;
      int n=intervals.length;
      while (i<n&&intervals[i][1]<newInterval[0]){
          ans.add(intervals[i++]);
      }
      while (i<n&&intervals[i][0]<=newInterval[1]){
          newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
          newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
          i++;
      }
      ans.add(newInterval);
      while (i<n){
          ans.add(intervals[i++]);
      }
      return ans.toArray(new int[ans.size()][]);
    }
}
