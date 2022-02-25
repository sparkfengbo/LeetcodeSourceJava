package 程序员面试金典;

import datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class L0202 {
    public static void main(String[] args) {
        System.out.println();

    }

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;


    }
}
