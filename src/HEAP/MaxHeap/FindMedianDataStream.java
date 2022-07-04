package HEAP.MaxHeap;

import java.util.PriorityQueue;

class FindMedianDataStream {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public static void main(String[] args) {
        FindMedianDataStream m=new FindMedianDataStream();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
    public FindMedianDataStream() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek())
            left.add(num);
        else
            right.add(num);

        if (left.size() > right.size())
            right.add(left.poll());
        if (right.size() > left.size())
            left.add(right.poll());
    }

    public double findMedian() {
        return left.size() != right.size() ? left.peek()
                : (double) (left.peek() + right.peek()) / 2;
    }
}