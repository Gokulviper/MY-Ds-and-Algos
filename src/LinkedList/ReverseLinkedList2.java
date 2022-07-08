package LinkedList;

class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode current  = head;
        ListNode prev = null;
        //go  to the first element as we need to reverse
        for(int i=0;current!=null && i<left-1;i++){
            prev = current;
            current = current.next;
        }
        ListNode last = prev; //the last handle the first connection
        ListNode newEnd = current; // teh newend easily connect first to last
        ListNode next = current.next;
        for(int i=0; current != null && i<right-left+1;i++){ //do reverse linking in opposite
            current.next = prev;
            prev = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }
        if(last!=null){
            last.next = prev; // the last is before starting node so connect previous the prevuios is your current
            //first node
        }else{
            head = prev;
        }
        newEnd.next = current;  //the newEnd is your chanagble elemnt is point the current
        return head;
    }
}