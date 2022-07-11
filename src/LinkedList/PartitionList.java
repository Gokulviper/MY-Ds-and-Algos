package LinkedList;

class PartitionList {
    public ListNode partition(ListNode head, int x) {

    ListNode first_head=new ListNode(-1);
        ListNode second_head=new ListNode(-1);
        ListNode first=first_head;
        ListNode second=second_head;
        while(head!=null){
            if(head.data<x){
                first.next=head;
                first=first.next;
            }else{
                second.next=head;
                second=second.next;
            }
            head=head.next;
        }
        second.next=null;
        first.next=second_head.next;
        return first_head.next;
    }
}