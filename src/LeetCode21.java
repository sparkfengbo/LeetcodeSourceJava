import datastruct.ListNode;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class LeetCode21 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);


        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(node1,node2);

        System.out.println(result);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;

        ListNode t1 = l1, t2 = l2;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                current.next = t1;
                t1 = t1.next;
                current = current.next;
            } else {
                current.next = t2;
                t2 = t2.next;
                current = current.next;
            }
        }

        while (t1 != null) {
            current.next = t1;
            t1 = t1.next;
            current = current.next;
        }

        while (t2 != null) {
            current.next = t2;
            t2 = t2.next;
            current = current.next;
        }

        return result.next;
    }
}
