package LinkedList;

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1==null)return list2;
      if (list2==null)return    list1;
     ListNode node=new ListNode(-1);
     ListNode current=node;
     while (list1!=null&&list2!=null){
         if (list1.data<=list2.data){
             current.next=list1;
             list1=list1.next;
         }else{
             current.next=list2;
             list2=list2.next;
         }
         current=current.next;
     }
     current.next=list1==null?list2:list1;
     return node.next;
    }

}