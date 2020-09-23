import datastruct.ListNode;

import java.util.Arrays;

public class LeetCode86 {

    /**
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
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
            if(current.val < x) {
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
}
