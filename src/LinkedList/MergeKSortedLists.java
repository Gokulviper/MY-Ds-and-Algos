package LinkedList;

import HEAP.MinHeap.MinPQ;

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        MinPQ pq=new MinPQ(10);
        for (ListNode nodes:lists){
            ListNode current=nodes;
            while (current!=null){
                pq.add(current.data);
                current=current.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        while (!pq.isEmpty()){
            ListNode node=new ListNode(pq.poll());
            current.next=node;
            current=current.next;
        }
        return dummy.next;
    }
}