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
    void insert(int index,int value,ListNode prev,int currentIndex,ListNode node1){
      if (node1==null){
          return;
      }
      if (index==1){
          ListNode node=new ListNode(value);
          node.next=node1;
          head=node;
          return;
      }
      if (currentIndex==index){
          ListNode node=new ListNode(value);
          ListNode t=node1;
          prev.next=node;
          node.next=t;
      }
      insert(index,value,node1,currentIndex+1,node1.next);
    }

    public static void main(String[] args) {
   RemoveDupicatesFromSortedList r=new RemoveDupicatesFromSortedList();


        LinkedList l=new LinkedList();
        l.add(1);
        l.add(1);
        l.add(2);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
        ;
       r.deleteDuplicates(l.head);


        l.print();
    }

    private  boolean search(int value) {
        if (head==null)return false;
        if (head.data==value)return true;
        ListNode current=head;
        while (current!=null){
            if (current.data==value){
                return true;
            }
            current=current.next;
        }
        return false;
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
