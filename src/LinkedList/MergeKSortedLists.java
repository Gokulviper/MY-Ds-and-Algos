package LinkedList;

import HEAP.MinHeap.MinPQ;

import java.util.PriorityQueue;

class MergeKSortedLists {
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a - b);
        ListNode list=new ListNode(-1);
        ListNode cur=list;
        for(ListNode l:lists){
            ListNode n=l;
            while(n!=null){

                pq.add(n.data);
                n=n.next;
            }
        }
        while(!pq.isEmpty()){
            int num=pq.poll();
            ListNode node=new ListNode(num);
            cur.next=node;
            cur=cur.next;
        }
        return list.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        MinPQ pq=new MinPQ(10);
        int len=0;
        for (ListNode nodes:lists){
            ListNode current=nodes;
            while (current!=null){
                len++;
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