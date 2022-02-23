package 剑指Offer;

import datastruct.ListNode;

public class Offer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (l1 != null && l2!= null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            current.next = l1;
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            current.next = l2;
            current = current.next;
            l2 = l2.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {

    }


}
