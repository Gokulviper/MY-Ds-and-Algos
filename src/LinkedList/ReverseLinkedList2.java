package LinkedList;

class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode current  = head;
        ListNode prev = null;
        for(int i=0;current!=null && i<left-1;i++){
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;
        ListNode next = current.next;
        for(int i=0; current != null && i<right-left+1;i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }
        if(last!=null){
            last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
}