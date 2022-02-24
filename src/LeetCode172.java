import datastruct.ListNode;
import datastruct.TreeNode;

import java.util.ArrayDeque;

public class LeetCode172 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        r1.left = l2;
        root.right = r1;

    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head;
        ListNode node1 = head, node2 = head;
        int cnt = 1;
        for (cnt = 1; cnt < k; cnt++) {
            fast = fast.next;
            node1 = node1.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        node2 = slow;
        int tmp = node2.val;
        node2.val = node1.val;
        node1.val = tmp;
        return head;
    }


}
