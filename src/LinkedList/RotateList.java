package LinkedList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k<=0)return head;
        ListNode current=head;
        int len=0;
        ListNode end=null;
        while (current!=null){
            if (current.next==null){
                end=current;
            }
            len++;
            current=current.next;
        }
        k=k%len;
        int n=len-k;
        ListNode cur=head;
        for (int i = 0; i <n-1 ; i++) {
            cur=cur.next;
        }
        end.next=head;
        ListNode newHead=cur.next;
        cur.next=null;
        head=newHead;
        return head;
    }
}
