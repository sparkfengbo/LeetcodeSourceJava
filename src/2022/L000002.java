import datastruct.ListNode;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class L000002 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

        System.out.println(addTwoNumbers(
                Utils.makeListNode(new int[]{2, 4, 3}),
                Utils.makeListNode(new int[]{5, 6, 7})
        ));
    }

    //2 4 3
    //5 6 7
    //7 0 8
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode( - 1);
        ListNode cur = dummy;
        boolean remain = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (remain ? 1 : 0);
            if (sum >= 10) {
                remain = true;
                sum %= 10;
            } else {
                remain = false;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode left = l1 != null ? l1 : l2;
        while (left != null) {
            int sum = left.val + (remain ? 1 : 0);
            if (sum >= 10) {
                remain = true;
                sum %= 10;
            } else {
                remain = false;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            left = left.next;
        }

        if (remain) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }

        return dummy.next;
    }
}
