package LinkedList;

import java.util.List;

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode prev=null,cur=head,next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;

        }

        return prev;
    }
    private ListNode recursive(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp = recursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public ListNode reverseList1(ListNode head) {
        //return iterative(head);
        return recursive(head);
    }
}