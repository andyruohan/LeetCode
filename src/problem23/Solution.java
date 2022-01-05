package problem23;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode result = new ListNode(Integer.MIN_VALUE);
        for (ListNode curNode : lists) {
            result = mergeTwoLists(result, curNode);
        }
        return result.next;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode curPoint = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curPoint.next = list1;
                list1 = list1.next;
            } else {
                curPoint.next = list2;
                list2 = list2.next;
            }
            curPoint = curPoint.next;
        }
        curPoint.next = list1 == null ? list2 : list1;
        return result.next;
    }
}
