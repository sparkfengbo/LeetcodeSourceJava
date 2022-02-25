package 程序员面试金典;

import datastruct.ListNode;

public class L0204 {
    public static void main(String[] args) {
        System.out.println();

    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode1 = new ListNode(0);
        ListNode node1 = dummyNode1;
        ListNode dummyNode2 = new ListNode(0);
        ListNode node2 = dummyNode2;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                node1.next = cur;
                node1 = node1.next;
            } else {
                node2.next = cur;
                node2 = node2.next;
            }
            cur = next;
        }
        node1.next = dummyNode2.next;
        node2.next = null;

        return dummyNode1.next;
    }
}
