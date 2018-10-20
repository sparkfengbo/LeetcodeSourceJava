import datastruct.ListNode;

/**
 * 删除排序链表中的重复元素
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class LeetCode83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(1);
        head2.next = node21;
        ListNode node31 = new ListNode(2);
        node21.next = node31;
        ListNode node41 = new ListNode(3);
        node31.next = node41;
        ListNode node51 = new ListNode(3);
        node41.next = node51;


        ListNode result = deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        int max = 0;

        ListNode tNode = head, tPrev = null;

        while (tNode != null) {

            if (tNode != head && max == tNode.val) {
                if (tPrev != null) {
                    tPrev.next = tNode.next;
                }
            } else {
                max = tNode.val;
                tPrev = tNode;
            }
            tNode = tNode.next;
        }

        return head;
    }
}
