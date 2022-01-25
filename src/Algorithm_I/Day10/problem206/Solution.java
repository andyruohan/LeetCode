package Algorithm_I.Day10.problem206;

import java.util.Stack;

public class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reverseList(head);
    }
}
