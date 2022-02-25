package 程序员面试金典;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class L0208 {
    public static void main(String[] args) {
        System.out.println();

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
               return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
