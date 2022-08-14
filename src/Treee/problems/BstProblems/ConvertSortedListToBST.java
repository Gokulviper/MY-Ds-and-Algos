package Treee.problems.BstProblems;
class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
class ConvertSortedListToBST {
    // Sorted List To BST Function
    public TreeNode sortedListToBST(ListNode head) {
        // if, head is null, means tree is doesn't exist
        if(head == null) return null;
        // if, head next is null, then return head value
        if(head.next == null) return new TreeNode(head.val);
        
        // Find Middle element
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        
        while(fast != null && fast.next != null) {
            // maintain prev variable to store slow value
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // create a node and add slow value on it
        TreeNode node = new TreeNode(slow.val);
        
        // & null is assign to previous next
        prev.next = null;
        // recursive call for left subtree
        node.left = sortedListToBST(head);
        // recursive call for right subtree
        node.right = sortedListToBST(slow.next);
        
        // finally, return node
        return node;
    }
}