package problem2;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curPoint = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            curPoint.val = sum % 10;
            carry = sum / 10;

            if (l1 != null || l2 != null) { //to get nextPoint
                ListNode newPoint = new ListNode();
                curPoint.next = newPoint;
                curPoint = newPoint;
            } else if (carry == 1) { //to get right answer when l1 == null and l2 == null with carry == 1
                curPoint.next = new ListNode(1);
            }
        }
        return result;
    }
}
