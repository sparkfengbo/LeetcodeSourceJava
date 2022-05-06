package 剑指Offer;

import datastruct.ListNode;

public class Offer18 {
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy, cur = head, next = cur.next;
            boolean find = cur.val == val;
            while (cur != null && cur.val != val) {
                pre = cur;
                cur = cur.next;
                if (cur != null) {
                    next = cur.next;
                }
                if (cur != null && cur.val == val) {
                    find = true;
                    break;
                }
            }
            if (find) {
                pre.next = next;
            }
            return dummy.next;
        }
    }


    public static void main(String[] args) {

    }


}
