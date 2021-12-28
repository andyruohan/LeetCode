package problem19;

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        if (head == null) {
            return null;
        }

        ListNode firstPointer = head;
        for (int i = 0; i < n - 1; i++) {
            if (firstPointer.next != null) {
                firstPointer = firstPointer.next;
            } else {
                return null;
            }
        }

        ListNode secondPointer = head;
        ListNode curPointer = new ListNode(head.val);
        ListNode result = curPointer;
        while (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
            curPointer.next = new ListNode(secondPointer.val);
            curPointer = curPointer.next;
        }

        if (n != 1) {
            if (secondPointer.next != null && secondPointer.next.next != null) {
                secondPointer = secondPointer.next.next;
                curPointer.next = new ListNode(secondPointer.val);
            }

            while (secondPointer.next != null) {
                secondPointer = secondPointer.next;
                curPointer.next = new ListNode(secondPointer.val);
                curPointer = curPointer.next;
            }
        }

        return result;
    }
}
