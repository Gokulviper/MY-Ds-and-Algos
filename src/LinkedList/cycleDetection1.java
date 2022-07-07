package LinkedList;

public class cycleDetection1 {
    public boolean hasCycle(ListNode head) {
          if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null&&fast.next!=null ) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    public int lengthOfCycle(ListNode head) {
        if (head == null || head.next == null)
            return 0;
        int length=0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null&&fast.next!=null ) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
               ListNode temp=slow.next;
              while (temp!=slow){
                  length++;
                  temp=temp.next;
              }
               return length;
            }
        }
        return length;
    }
}