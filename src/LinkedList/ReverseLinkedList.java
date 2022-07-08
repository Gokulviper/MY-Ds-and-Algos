package LinkedList;

import java.util.List;

class ReverseLinkedList {
    private ListNode recursive(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp = recursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public ListNode reverseList(ListNode head) {
        //return iterative(head);
        return recursive(head);
    }
}