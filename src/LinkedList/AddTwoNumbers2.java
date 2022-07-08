package LinkedList;

public class AddTwoNumbers2 {
    public static void main(String[] args) {


    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        addTheNumbers1(l1,s1);
        addTheNumbers1(l2,s2);
        StringBuilder ans= add(s1,s2);
        ListNode node =new ListNode(-1);
        ListNode current=node;
        if (ans.charAt(0)=='0'){
            ListNode node1=new ListNode(0);
            current.next=node1;
        }else{
            for (int i = 0; i <ans.length() ; i++) {
                int num=ans.charAt(i)-'0';
                ListNode node1=new ListNode(num);
                current.next=node1;
                current=current.next;
            }
        }
        return node.next;
    }
    private void addTheNumbers1(ListNode head, StringBuilder sb) {
        while (head!=null){
            sb.append(head.data);
            head=head.next;
        }
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

}

