package HEAP.MinHeap;

import java.util.PriorityQueue;

class KthLargest {
//why minHeap
    /*
    the array contains 3 5 6 and k=3
    you can 4 so the after 3 4 5 6
    so the first peek is never being our answer that is use minheap
    and maintain the size is k
    remove 3 after the array is 4 5 6
    return the third largest in peek -> 4
     */
    PriorityQueue<Integer> p;
    int k;

    public KthLargest(int k, int[] nums) {
        //initializee size is minHeap
        this.k = k;
        p = new PriorityQueue<>(k);
      for (int n : nums)
            add(n);  // Here We Calling Below Function add
    }

    public int add(int val) {
        if (p.size() < k) {
            p.add(val);
        }
       else  {
           
            p.add(val);
            p.poll();
        }
        return p.peek();
    }
}