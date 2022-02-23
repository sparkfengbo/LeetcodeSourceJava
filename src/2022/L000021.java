import datastruct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class L000021 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode node = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else if (list2 != null) {
            node.next = list2;
        }
        return result.next;

    }
}
