package LinkedList;

public class SumOfLinkedList {
    public static void main(String[] args) {

    }
   int sum(ListNode head){
        if (head==null)return 0;
        int sum=0;
        ListNode current=head;
        while (current!=null){
            sum+=current.data;
            current=current.next;
        }
        return sum;
   }
}
