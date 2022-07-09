package LinkedList;

class ReorderLits {
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev ;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;
        // rearrange
        while(hf != null && hs != null){
            // for the first half
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            // for the second half
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        // next of tail to null
        if (hf != null){
            hf.next = null;
        }

    }
}