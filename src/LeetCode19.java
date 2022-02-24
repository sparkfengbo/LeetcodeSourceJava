import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode19 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new datastruct.ListNode(2);
        root.next.next = new datastruct.ListNode(3);
        root.next.next.next = new datastruct.ListNode(4);
        root.next.next.next.next = new datastruct.ListNode(5);


//        ListNode ans = removeNthFromEnd(root, 2);
//        ListNode ans = removeNthFromEnd(root, 1);
        ListNode ans = removeNthFromEnd(root, 5);

        System.out.print("");
    }


    public static ListNode removeNthFromEnd_2022(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    /**
     * 双指针， 快慢指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //1->2->3->4->5
        //1->2->3
        ListNode slow = head, slowPrev = null, fast = head;
        int count = 1;
        boolean findSlow = false;
        while (fast.next != null) {
            if (n == count) {
                findSlow = true;
            }
            if (findSlow) {
                slowPrev = slow;
                slow = slow.next;
            }
            count++;
            fast = fast.next;
        }
        if (slowPrev != null) {
            slowPrev.next = slow.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
