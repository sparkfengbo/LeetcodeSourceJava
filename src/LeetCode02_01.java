import datastruct.ListNode;

import java.util.HashSet;

public class LeetCode02_01 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(1);
        head2.next = node21;
        ListNode node31 = new ListNode(2);
        node21.next = node31;
        ListNode node41 = new ListNode(3);
        node31.next = node41;
        ListNode node51 = new ListNode(3);
        node41.next = node51;


        ListNode result = deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        if (head == null) {
            return head;
        }
        set.add(head.val);
        ListNode tNode = head.next, tPrev = head;
        while (tNode != null) {
            if (set.contains(tNode.val)) {
                tPrev.next = tNode.next;
            } else {
                set.add(tNode.val);
                tPrev = tNode;
            }
            tNode = tNode.next;
        }

        return head;
    }

    //    链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci/solution/yi-chu-zhong-fu-jie-dian-by-leetcode-solution/
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
    }

}
