/**
 * 删除链表中的节点
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class LeetCode203 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        head.next = node2;
//        ListNode node3 = new ListNode(6);
//        node2.next = node3;
//        ListNode node4 = new ListNode(3);
//        node3.next = node4;
//        ListNode node5 = new ListNode(4);
//        node4.next = node5;
//        ListNode node6 = new ListNode(5);
//        node5.next = node6;
//        ListNode node7 = new ListNode(6);
//        node6.next = node7;
//        ListNode result = removeElements(head, 6);


//        ListNode head2 = new ListNode(1);
//        ListNode result2 = removeElements(head2, 1);


        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        node3.next = node4;
        ListNode result3 = removeElements(head, 1);

        System.out.println("debug pause");
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null, node = head;

        while (node != null) {
            if (node.val == val) {
                if (node == head) {
                    head = head.next;
                } else {
                    if (prev != null) {
                        prev.next = node.next;
                    }
                }
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }

}
