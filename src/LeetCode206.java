import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表
 * <p>
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class LeetCode206 {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode result = reverseList(root);
        System.out.println();
    }


    //这个解法有点歪，其实用栈就能解决
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevNode = new ListNode(-1);
        ListNode currentNode = prevNode;

        List<Integer> tempList = new ArrayList<>();

        while (head != null) {
            tempList.add(head.val);
            head = head.next;
        }

        for (int i = tempList.size() - 1; i >= 0; i--) {
            ListNode node = new ListNode(tempList.get(i));
            currentNode.next = node;
            currentNode = currentNode.next;
        }

        return prevNode.next;
    }

    //迭代  一遍遍历就可解决
    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = first.next;
        first.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;
        }
        return first;
    }

}
