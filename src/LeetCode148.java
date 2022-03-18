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

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            if (head.next.next == null) {
                ListNode next = head.next;
                if (next.val < head.val) {
                    next.next = head;
                    head.next = null;
                    return next;
                }
                return head;
            }

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode next = slow.next;
            slow.next = null;

            ListNode list1 = sortList(head);
            ListNode list2 = sortList(next);
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                    cur = cur.next;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                }
            }
            ListNode left = list1 == null ? list2 : list1;
            while (left != null) {
                cur.next = left;
                left = left.next;
                cur = cur.next;

            }
            return dummy.next;
        }
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
