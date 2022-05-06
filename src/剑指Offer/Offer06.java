package 剑指Offer;

import datastruct.ListNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Offer06 {

//    class Solution {
//        public int[] reversePrint(ListNode head) {
//
//        }
//    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int[] ans = new int[length];
        int i = length - 1;
        curr = head;
        while (curr != null) {
            ans[i--] = curr.val;
            curr = curr.next;
        }
        return ans;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
