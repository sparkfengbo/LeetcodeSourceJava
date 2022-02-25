package 程序员面试金典;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class L0206 {
    public static void main(String[] args) {
        System.out.println();

    }

    /**
     * 时间 On
     * 空间 O1
     * 先快慢指针找到中间位置，翻转尾链表，比对，再翻转尾链表，还原。
     * 这种做法太复杂，而且会影响原结构，我不是很认可，
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur= next;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
