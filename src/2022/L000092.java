import datastruct.ListNode;

public class L000092 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }


    /**
     * 思路，先找到要翻转的子链表，找到LeftNode， RightNode， 和LeftNode的前节点pre，RightNode的后节点Curr
     * 翻转LeftNode到RightNode
     * 再衔接
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;

        return dummy.next;
    }

    private static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }


    /**
     * 一趟遍历方法，头插，每次讲新的RightNode插到队首
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
