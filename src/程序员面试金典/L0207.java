package 程序员面试金典;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class L0207 {
    public static void main(String[] args) {
        System.out.println();

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
