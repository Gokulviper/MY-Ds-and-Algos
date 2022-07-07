package LinkedList;

public class RemoveDupicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)return null;
     ListNode current=head;
     while (current.next!=null){
         if (current.data==current.next.data){
             current.next=current.next.next;
         }else{
             current=current.next;
         }
     }
     return head;
    }
}
