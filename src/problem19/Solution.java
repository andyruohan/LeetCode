package problem19;

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        if (head == null) {
            return null;
        }

        TwoPointersListNode curPointer1 = new TwoPointersListNode(head.val);
        curPointer1.next = head.next;
        while (head != null) {
            if (head.next != null && head.next.next != null) {
                curPointer1 = new TwoPointersListNode(head.val);
                curPointer1.next = new ListNode(head.next.next.val);
            } else if (head.next != null && head.next.next == null) {
                curPointer1 = new TwoPointersListNode(head.val);
            }
            curPointer1.pre = new ListNode(head.val);
            head = head.next;
        }

        TwoPointersListNode curPointer2 = new TwoPointersListNode(0);
        int index = 1;
        while (curPointer1 != null) {
        }
    }
}
