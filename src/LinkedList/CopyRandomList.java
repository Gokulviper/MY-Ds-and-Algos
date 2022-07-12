package LinkedList;

import java.util.HashMap;

class Node{
    Node next;
    int val;
    Node random;
    Node(int val){
        this.val=val;
    }
}
class CopyRandomList {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap();
        Node cur=head;
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
       return map.get(head);
    }
}