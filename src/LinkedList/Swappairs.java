package LinkedList;

class Swappairs {
    public ListNode swapPairs(ListNode head) {
        ListNode temp=new ListNode(-1);
        temp.next=head;
        ListNode prev=temp;
        while(prev.next!=null&&prev.next.next!=null){
            ListNode first=prev.next;
            ListNode second=prev.next.next;
            first.next=second.next;
            second.next=first;
            prev.next=second;
            prev=first;
        }
        return temp.next;
    }
}