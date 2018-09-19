import java.util.Arrays;
import java.util.HashSet;

/**
 * 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 进阶：
 * 你能否不使用额外空间解决此题？
 */
public class LeetCode141 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;

        node4.next = node1;
        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }

        return false;
    }


    /**
     *
     * https://blog.csdn.net/qq_37765748/article/details/80014060
     * 
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }


    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode l = head.next;
        head.next = head;
        boolean isCycle = hasCycle2(l);
        return isCycle;
    }
}
