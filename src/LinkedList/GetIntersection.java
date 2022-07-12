package LinkedList;

public class GetIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode a=headA,b=headB;
        while(a!=b){
            if(a==null){
                a=headB;
            }else{
                a=a.next;
            }
            if(b==null){
                b=headA;
            }else{
                b=b.next;
            }
        }
        return b;
    }
}