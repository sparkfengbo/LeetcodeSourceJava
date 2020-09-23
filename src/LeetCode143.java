import datastruct.ListNode;


public class LeetCode143 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
//        node4.next = node2;
//        reorderList(root);
        System.out.println("");
    }

    /**
     * https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
     * 下面的解法把循环放在前面，有点暴力，很慢
     * @param head
     */
//    public static void reorderList(ListNode head) {
//        if (head == null || head.next == null) {
//            return;
//        }
//        ListNode current = head, prev = null;
//        while (current.next != null) {
//            prev = current;
//            current = current.next;
//        }
//        if (prev != null) {
//            prev.next = null;
//        }
//        ListNode subListHead = head.next;
//        head.next = current;
//        current.next = subListHead;
//        reorderList(subListHead);
//    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
    }
}
