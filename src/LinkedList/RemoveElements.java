package LinkedList;

class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return null;
       ListNode node=new ListNode(-1);
        node.next=head;
        ListNode prev=node;
        while(head!=null){
            if(head.data==val){
                prev.next=head.next;
                
            }else{
                prev=head;
              
            }
            head=head.next;
        }
        return node.next;
    }
}