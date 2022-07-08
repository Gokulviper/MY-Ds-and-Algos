package LinkedList.CycleDetectionProblems;



//if you find the same point fix again the slow
// as head and run boht fast and slow move one step then that meets return node
public class CylecDetection2 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        boolean cycleDetected=false;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=cycleDetected?fast.next:fast.next.next;
            if(fast==slow&&!cycleDetected){
                slow=head;
                cycleDetected=true;
            }
            if(fast==slow&&cycleDetected){
                return slow;
            }
        }
        return null;
    }
}