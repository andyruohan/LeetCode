package problem24;

public class Solution {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2; //temp.next和node1分别代表不同的指针，temp.next指向的其他位置，并不影响node1的指向
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head.val + " "+ head.next.val + " " + head.next.next.val + " "+ head.next.next.next.val);
        ListNode newHead = swapPairs(head);
        System.out.println(newHead.val + " "+ newHead.next.val + " " + newHead.next.next.val + " "+ newHead.next.next.next.val);
    }
}
