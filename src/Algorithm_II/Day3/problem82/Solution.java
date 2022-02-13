package Algorithm_II.Day3.problem82;

public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode lowerPointer = head;
        ListNode fasterPointer = head;
        ListNode result = new ListNode(0, head);

        while (head.next != null) {
            fasterPointer.next = head.next;
            if (lowerPointer.val != fasterPointer.next.val) {
                lowerPointer.next = head.next;
                lowerPointer = lowerPointer.next;
            }
            fasterPointer = fasterPointer.next;
            head = head.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(3);
        node1.next.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next.next.next = new ListNode(5);
        ListNode result = deleteDuplicates(node1);
        System.out.println(result);
    }
}
