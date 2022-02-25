package 程序员面试金典;

import datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class L0201 {
    public static void main(String[] args) {
        System.out.println();

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();

        ListNode dummy =new ListNode( -1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                pre= cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
