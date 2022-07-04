package HEAP.MaxHeap;

import java.util.PriorityQueue;
/*
use the ,min heap and max heap
maintain the max and min values
if you want a median get the peak of both
because left is max so sorted in decending
the max value right ,maintain size is equal
 */
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
        right = new PriorityQueue<>();//the right is min heap stores in the direct
        left = new PriorityQueue<>((a, b) -> b  -a);//but this max check any element add before the num is less then your peek
    }

    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek())//this is check maintain left as a max heap
            left.add(num);
        else
            right.add(num);

        if (left.size() > right.size()) //if the size is greater the peek and exchange it
            right.add(left.poll());
        if (right.size() > left.size())
            left.add(right.poll());
    }

    public double findMedian() {
        return left.size() != right.size() ? left.peek()
                : (double) (left.peek() + right.peek()) / 2;
    }
}