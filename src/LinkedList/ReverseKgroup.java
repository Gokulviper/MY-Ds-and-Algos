package LinkedList;

class ReverseKgroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) {
            return head;
        }

        ListNode present = head;
        ListNode previous = null;

        while (true) {
            ListNode last = previous;
            ListNode end = present;

            ListNode newPresent = present;
            for (int i = 0; newPresent != null && i < k  - 1; i++) {
                newPresent = newPresent.next;
            }

            if (newPresent == null) {
                break;
            }

            ListNode next = present.next;
            for (int i = 0; present != null && i < k; i++) {
                present.next = previous;
                previous = present;
                present = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = previous;
            } else {
                head = previous;
            }

            end.next = present;

            if (present == null) {
                break;
            }

            previous = end;
        }
        return head;
    }
}