import datastruct.ListNode;

/**
 * 环形链表 II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class LeetCode142 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;

//        node4.next = node2;

        System.out.println(detectCycle(node1));
    }

    /**
     *
     * 思路是 一个快指针 一个慢指针， 快指针每次移动2步，满指针每次一步，
     *
     * 如果存在环的话，两者一定会相交，否则不会出现环
     *
     * 如果出现环，在相交的地方，把快指针移到head，当两个指针再次相交，就是环起始的位置
     *
     *
     * 参考了 https://blog.csdn.net/u013077144/article/details/81070415
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (true) {
            //查询到末尾，肯定没环
            if (fastNode.next == null
                    || fastNode.next.next == null
                    || slowNode.next == null) {
                return null;
            }

            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (fastNode == slowNode) {
                break;
            }
        }

        fastNode = head;

        while (fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }

}
