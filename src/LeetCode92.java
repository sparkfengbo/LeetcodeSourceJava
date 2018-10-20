import datastruct.ListNode;

/**
 * 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class LeetCode92 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//        root.next = new datastruct.ListNode(2);
//        root.next.next = new datastruct.ListNode(3);
//        root.next.next.next = new datastruct.ListNode(4);
//        root.next.next.next.next = new datastruct.ListNode(5);
        ListNode result = reverseBetween(root, 1, 1);
        System.out.println();
    }

    /**
     * O（n）的遍历，问题是在于翻转时会操作指针，操作后还要按原指针的顺序遍历
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        if (m == n) {
            return head;
        }

        ListNode rawPrev = null, current = head, rawNext;
        ListNode prevReverseHead = null, nextReverseNail = null;
        ListNode reverseHead = null, reverseNail = null;

        int index = 1;
        while (current != null) {
            if (index == m) {
                prevReverseHead = rawPrev;
            } else if (index == n) {
                nextReverseNail = current.next;
            }

            rawNext = current.next;

            //这里做翻转,做前一个node的翻转
            if (index >= m && index <= n) {
                if (index == m) {
                    reverseNail = current;
                }

                if (index == n) {
                    reverseHead = current;
                }
                current.next = rawPrev;
            }
            rawPrev = current;
            current = rawNext;
            index++;
        }

        reverseNail.next = nextReverseNail;
        if (prevReverseHead != null) {
            prevReverseHead.next = reverseHead;
        }

        if (m == 1) {
            return reverseHead;
        } else {
            return head;
        }
    }
}
