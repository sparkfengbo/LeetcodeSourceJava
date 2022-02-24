import datastruct.ListNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class L000061 extends Template {

    public static void main(String[] args) {

        ListNode r = rotateRight(Utils.makeListNode(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }

        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        cur.next = head;
        ListNode finalHead = head;

        int finalHeadIndex = length - k % length;
        for (int i = 0; i < finalHeadIndex; i++) {
            if (i == finalHeadIndex - 1) {
                ListNode node = finalHead.next;
                finalHead.next = null;
                finalHead = node;
                break;
            }
            finalHead = finalHead.next;
        }
        return finalHead;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        k %= length;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = head;
        int cnt = 0;
        while (true) {
            if (cnt == k) {
                slow = slow.next;
            } else {
                cnt++;
            }
            if (fast.next == null) {
                fast.next = head;
                break;
            }
            fast = fast.next;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        return newhead;
    }

}
