package 程序员面试金典;

import datastruct.ListNode;

public class L0205 {
    public static void main(String[] args) {
        System.out.println();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        ListNode node1 = l1;
        ListNode node2 = l2;
        boolean carry = false;
        while (node1 != null && node2 != null) {
            int tmp = node1.val + node2.val + (carry ? 1 : 0);
            ListNode n = new ListNode(tmp % 10);
            cur.next = n;
            cur = cur.next;
            carry = tmp >= 10;
            node1 = node1.next;
            node2 = node2.next;
        }

        ListNode node = node1 == null ? node2 : node1;
        while (node != null) {
            int tmp = node.val + (carry ? 1 : 0);
            ListNode n = new ListNode(tmp % 10);
            cur.next = n;
            cur = cur.next;
            node = node.next;
            carry = tmp >= 10;
        }

        if (carry) {
            ListNode n = new ListNode(1);
            cur.next = n;
        }

        return  dummyNode.next;

    }
}
