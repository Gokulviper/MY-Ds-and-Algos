package LinkedList;

class RemoveDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
    if (head==null)return null;
    ListNode node=new ListNode(-1);
    ListNode prev=node;
    while (head.next!=null){
        if (head.next!=null&&head.data==head.next.data){
            while (head.next!=null&&head.data==head.next.data){
                head=head.next;
            }
            prev.next=head.next;
        }else{
            prev=prev.next;
        }
        head=head.next;
    }
    return node.next;

    }
}