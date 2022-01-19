package Algorithm_I.Day5.problem876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        int offset = length / 2;
        int index = 0;
        while (result.next != null && index < offset) {
            result = result.next;
            index++;
        }

        return result.next;
    }
}
