package LinkedList;

class pallindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode mid=getMid(head);
        ListNode sh=reverse(mid);
        while(sh!=null){
            if(sh.data!=head.data){
                return false;
            }else{
                sh=sh.next;
                head=head.next;
            }
        }
        return true;
     
}
    ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=cur.next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    
}