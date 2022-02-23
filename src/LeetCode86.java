import datastruct.ListNode;

import java.util.Arrays;

public class LeetCode86 {

    /**
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode before = new ListNode(0), after = new ListNode(0);
        ListNode beforeNode = before, afterNode = after;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                beforeNode.next = current;
                beforeNode = beforeNode.next;
            }
            if (current.val >= x) {
                afterNode.next = current;
                afterNode = afterNode.next;
            }
            current = current.next;
        }

        beforeNode.next = after.next;
        afterNode.next = null;

        return before.next;
    }

    public static ListNode partition2(ListNode head, int x) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur = head;
        ListNode pivot = null, prePivot = null;

        while (cur != null) {
            if (cur.val < x && pivot != null) {
                ListNode next = cur.next;
                //断链
                pre.next = next;
                cur.next = pivot;
                prePivot.next = cur;
                prePivot = cur;
                cur = next;
            } else if (pivot == null && cur.val >= x) {
                prePivot = pre;
                pivot = cur;
                pre = cur;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
