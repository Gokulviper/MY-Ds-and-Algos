package ArrayProblems.BinarySearch.Matrix;

import java.util.Arrays;

public class BinarySearchInSortedMatrix {
    public static void main(String[] args) {
        int[][]nums={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(search(nums,77)));

    }
    static int[]binarySearch(int[][]matrix,int row,int cStart,int cEnd,int target){
        while (cStart<=cEnd ){
            int mid=cStart+(cEnd-cStart)/2;
            if(matrix[row][mid]==target){
                return new int[]{row,mid};
            }
            if(matrix[row][mid]<target){
                cStart=mid+1;

            }else{
                cEnd=mid-1;
            }
        }return new int[]{-1,-1};
    }
    static int[]search(int[][]matrix,int target){
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(rows==1){
            return binarySearch(matrix,0,0,cols-1,target);
        }
        int rStart=0,rEnd=rows-1,cMid=cols/2;
        // run the loop till two rows are remaining
        while (rStart<(rEnd-1)){
            int mid=rStart+(rEnd-rStart)/2;
            if (matrix[mid][cMid]==target){
                return new int[]{mid,cMid};
            }
          else  if (matrix[mid][cMid]<target){
               rStart=mid;
            }else{
              rEnd=mid;
            }
        }
        //now loop ends now we have two rows /
        //check whether the target in the colum on the two rows
        if (matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if (matrix[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }
        //search in first half
        if (target<=matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }
        //search in 2nd half
        if (target>=matrix[rStart][cMid+1]&&target<=matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart,cMid+1,cols-1,target);
        }
        //search in 3nd half
        if (target<=matrix[rStart+1][cMid-1]){
            return binarySearch(matrix,rStart+1,0,cMid-1,target);

        }else{
            //search in 4th half
            return binarySearch(matrix,rStart+1,cMid+1,cols-1,target);

        }


    }

}
