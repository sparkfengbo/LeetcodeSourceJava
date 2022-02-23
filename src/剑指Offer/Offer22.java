package 剑指Offer;

import datastruct.ListNode;
import datastruct.TreeNode;

import java.util.*;

public class Offer22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//
//        while (--k > 0) {
//            stack.pop();
//        }
//
//        return stack.peek();

        ListNode left = head, right = head;
        for(int i = 0; i < k; i++)
            right = right.next;
        while(right != null) {
            right = right.next;
            left = left.next;
        }
        return left;

    }

    public static void main(String[] args) {

    }


}
