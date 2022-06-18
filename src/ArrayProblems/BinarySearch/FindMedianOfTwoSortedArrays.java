package ArrayProblems.BinarySearch;

class FindMedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int m=arr1.length,n=arr2.length;
        if(m>n){
        return findMedianSortedArrays(arr2,arr1);//ensuring that //binary search happens on minimum size array
        }
    int low=0,high=m,medianPos=((m+n)+1)/2;
    while(low<=high) {
        int mid1 = (low+high)>>1;
        int mid2 = medianPos - mid1;
        
        int l1 = (mid1 == 0)? Integer.MIN_VALUE:arr1[mid1-1];
        int l2 = (mid2 == 0)? Integer.MIN_VALUE:arr2[mid2-1];
        int r1 = (mid1 == m)? Integer.MAX_VALUE:arr1[mid1];
        int r2 = (mid2 == n)? Integer.MAX_VALUE:arr2[mid2];
        
        if(l1<=r2 && l2<=r1) {
            if((m+n)%2 != 0)
                return Math.max(l1,l2);
            else 
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
        }
        else if(l1>r2) high = mid1-1;
        else low = mid1+1;
    }
    return 0.0;
    }
}