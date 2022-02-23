import datastruct.ListNode;
import utils.Utils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class L000445 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

//        System.out.println(addTwoNumbers(
//                Utils.makeListNode(new int[]{2, 4, 3}),
//                Utils.makeListNode(new int[]{5, 6, 7})
//        ));
    }

    /**
     * 逆序相加使用栈
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode ans = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty()? 0 : stack1.pop();
            int b = stack2.isEmpty()? 0 : stack2.pop();
            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = ans;
            ans = node;
        }
        return ans;
    }

    /**
     * 翻转链表，倒序相加，再翻转
     * 相关题目： 剑指offer24， Leetcode两数相加002
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseList(addTwoNumbersReverse(reverseList(l1), reverseList(l2)));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = head, cur = head.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head.next = null;
        return prev;
    }

    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
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
