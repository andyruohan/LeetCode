package Algorithm_I.Day5.problem19;

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        if (head == null) {
            return null;
        }

        ListNode firstPointer = head;
        for (int i = 0; i < n; i++) {
            firstPointer = firstPointer.next;
        }

        ListNode result = new ListNode(0, head);
        ListNode secondPointer = result;
        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        secondPointer.next = secondPointer.next.next;
        return result.next;
    }
}
