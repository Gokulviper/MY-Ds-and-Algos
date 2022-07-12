package LinkedList;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public ListNode oddEvenLis1t(ListNode head) {
        //another approach
        if(head==null||head.next==null)return head;
        ListNode odd=new ListNode(-1);
        ListNode even=new ListNode(-1);
        ListNode odd_cur=odd,even_cur=even;
        int len=1;
        while(head!=null){
            if(len%2==0){
                even_cur.next=head;
                even_cur=even_cur.next;
            }else{
                odd_cur.next=head;
                odd_cur=odd_cur.next;
            }
            head=head.next;
            len++;
        }
        even_cur.next=null;
        odd_cur.next=even.next;
        return odd.next;
    }
}