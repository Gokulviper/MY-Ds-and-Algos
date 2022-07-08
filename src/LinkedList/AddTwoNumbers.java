package LinkedList;

import javax.swing.event.ListDataEvent;

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)return null;
        if (l1==null)return l2;
        if (l2==null)return l1;
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        addTheNumbers(l1,s1);
        addTheNumbers(l2,s2);
        StringBuilder ans= add(s1,s2);
        ListNode node =new ListNode(-1);
        ListNode current=node;
        if (ans.charAt(0)=='0'){
            ListNode node1=new ListNode(0);
            current.next=node1;
        }else{
            for (int i = ans.length()-1; i >=0 ; i--) {
                int num=ans.charAt(i)-'0';
                ListNode node1=new ListNode(num);
                current.next=node1;
                current=current.next;
            }
        }
        return node.next;

    }
    StringBuilder add(StringBuilder s1,StringBuilder s2){
        StringBuilder ans=new StringBuilder();
        int i=s1.length()-1,j=s2.length()-1,carry=0;
        while (i>=0||j>=0||carry>0){

            int num1=(i>=0)?s1.charAt(i--)-'0':0;
            int num2=(j>=0)?s2.charAt(j--)-'0':0;
            int sum=num1+num2+carry;
            ans.insert(0,sum%10);
            carry=sum/10;
        }
        return ans;
    }
    void addTheNumbers(ListNode head,StringBuilder sb){
        while (head!=null){
            sb.insert(0,head.data);
            head=head.next;
        }
    }


}