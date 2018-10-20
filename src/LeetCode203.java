import datastruct.ListNode;

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

    public static void main(String[] args) {
//        datastruct.ListNode head = new datastruct.ListNode(1);
//        datastruct.ListNode node2 = new datastruct.ListNode(2);
//        head.next = node2;
//        datastruct.ListNode node3 = new datastruct.ListNode(6);
//        node2.next = node3;
//        datastruct.ListNode node4 = new datastruct.ListNode(3);
//        node3.next = node4;
//        datastruct.ListNode node5 = new datastruct.ListNode(4);
//        node4.next = node5;
//        datastruct.ListNode node6 = new datastruct.ListNode(5);
//        node5.next = node6;
//        datastruct.ListNode node7 = new datastruct.ListNode(6);
//        node6.next = node7;
//        datastruct.ListNode result = removeElements(head, 6);


//        datastruct.ListNode head2 = new datastruct.ListNode(1);
//        datastruct.ListNode result2 = removeElements(head2, 1);


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
