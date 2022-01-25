package Algorithm_I.Day10.problem206;

import java.util.Stack;

public class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode curNode = stack.pop();
        ListNode result = new ListNode(0, curNode);
        while (!stack.isEmpty()) {
            curNode.next = stack.pop();
            curNode = curNode.next;
        }
        curNode.next = null;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reverseList(head);
    }
}
