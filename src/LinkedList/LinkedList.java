package LinkedList;

import java.util.List;

class ListNode{
  int data;
  ListNode next;
   ListNode(int data){
       this.data=data;
       this.next=null;
   }
}
public class LinkedList {
    ListNode head;
    void add(int value){
        ListNode node=new ListNode(value);
        if (head==null){
            head=node;
            return;
        }
        ListNode current=head;
        while (current.next!=null){
            current=current.next;
        }
        current.next=node;
    }
    void print(){
        if(head==null){
            System.out.println("no nodes ");
            return;
        }
        ListNode current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.add(5);
        l.add(6);
        l.add(2);
        l.add(9);
        l.add(10);

        l.print();
        l.remove(6);
        System.out.println();
        l.print();
    }

    private void remove(int value) {
        if (head==null)return;
        if (head.data==value){
            head=head.next;
            return;
        }
        ListNode prev=null;
        ListNode current=head;
        while (current.data!=value){

            prev=current;
            current=current.next;
        }
        prev.next=current.next;

        current.next=null;


    }

}
