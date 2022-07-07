package LinkedList;

public class RemoveDupicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)return null;
       if (head.next==null)return head;
        ListNode prev=head;
        ListNode current=head.next;
        while (current!=null){
            if (prev.data==current.data){
                prev.next=current.next;
               //current=current.next;
            }
            current=current.next;
            prev=prev.next;
        }
        return head;
    }
}
