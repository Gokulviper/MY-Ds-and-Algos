package HEAP.MaxHeap;

class KthLargestElement {
    public static void main(String[] args) {
//nums = [3,2,1,5,6,4], k = 2
        int[]nums={7,6,5,4,3,2,1};
        int k=5;
        System.out.println(findKthLargest(nums,k));
    }
    public static int findKthLargest(int[] nums, int k) {
        MaxPq pq=new MaxPq(nums.length+1);
        for (int num:nums){
            pq.insert(num);
        }
        int max=0;
        int i=0;
        while (!pq.isEmpty()){
            max=pq.poll();
            i++;
            if (i==k)break;
        }
        return max;
    }
}