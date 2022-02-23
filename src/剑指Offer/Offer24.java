package 剑指Offer;

import datastruct.ListNode;

public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head, cur = head.next;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = null;
        return prev;
    }

    public static void main(String[] args) {

    }
}
