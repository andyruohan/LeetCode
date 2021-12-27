package problem19;

public class TwoPointersListNode {
    int val;
    ListNode next;
    ListNode pre;
    TwoPointersListNode() {}
    TwoPointersListNode(int val) { this.val = val; }
    TwoPointersListNode(int val, ListNode next, ListNode pre) { this.val = val; this.next = next; this.pre = pre;}
}
