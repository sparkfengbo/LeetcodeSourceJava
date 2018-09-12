import java.util.HashSet;

/**
 * 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class LeetCode82 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        head.next = node2;
//        ListNode node3 = new ListNode(2);
//        node2.next = node3;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(1);
        head2.next = node21;
        ListNode node31 = new ListNode(1);
        node21.next = node31;
        ListNode node41 = new ListNode(2);
        node31.next = node41;
        ListNode node51 = new ListNode(3);
        node41.next = node51;
        ListNode node61 = new ListNode(5689);
        node51.next = node61;


        ListNode result = deleteDuplicates(head2);

        System.out.println("");

    }


    /**
     * 思路： 两边遍历
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tNode = head, tPrev = null, resultHead = null;
        HashSet<Integer> keys = new HashSet<>();

        while (tNode != null && tNode.next != null) {
            if (tNode.val == tNode.next.val) {
                keys.add(tNode.val);
                tNode = tNode.next.next;
            } else {
                tNode = tNode.next;
            }
        }


        tNode = head;
        while (tNode != null) {
            if (!keys.contains(tNode.val)) {
                //确定head的位置
                if (resultHead == null) {
                    //移除其他node对resultHead的引用
                    if (tPrev != null) {
                        tPrev.next = null;
                    }
                    resultHead = tNode;
                }
                tPrev = tNode;
                tNode = tNode.next;
            } else {
                if (tPrev != null) {
                    tPrev.next = tNode.next;
                }
                tNode = tNode.next;
            }
        }
        return resultHead;
    }


    /**
     * 思路：双指针
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fakeNode = new ListNode(-1);

        ListNode result = fakeNode;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.next.val == pre.val)
                cur = cur.next;
            if (cur == pre) {
                result.next = pre;
                result = result.next;
            }
            pre = cur.next;
            cur = cur.next;
        }
        result.next = cur;
        return fakeNode.next;
    }
}
