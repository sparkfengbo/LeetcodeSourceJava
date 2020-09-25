import datastruct.ListNode;
import utils.Utils;

public class LeetCode148 {


    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);

        ListNode r = sortList(root);
        Utils.print("");
    }

    //https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        //断链
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode p0 = left, p1 = right;
        ListNode dummyNode = new ListNode(-1);

        ListNode current = dummyNode;
        while (p0 != null && p1 != null) {
            if (p0.val < p1.val) {
                current.next = p0;
                p0 = p0.next;
                current = current.next;
            } else {
                current.next = p1;
                p1 = p1.next;
                current = current.next;
            }
        }

        while (p0 != null) {
            current.next = p0;
            p0 = p0.next;
            current = current.next;
        }

        while (p1 != null) {
            current.next = p1;
            p1 = p1.next;
            current = current.next;
        }
        return dummyNode.next;
    }
}
