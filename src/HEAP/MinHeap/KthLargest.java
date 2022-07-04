package HEAP.MinHeap;

import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> p;
    int k;

    public KthLargest(int k, int[] nums) {
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