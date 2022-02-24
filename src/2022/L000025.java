import datastruct.ListNode;
import utils.Utils;

public class L000025 extends Template {

    public static void main(String[] args) {
        ListNode r = reverseKGroup(Utils.makeListNode(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            int cnt = 1;
            while (cnt < k) {
                cur = cur.next;
                cnt++;
                if (cur == null) {
                    return dummy.next;
                }
            }
            ListNode next = cur.next;
            ListNode[] nodes = reverseList(pre.next, cur);
            pre.next = nodes[0];
            nodes[1].next = next;
            pre = nodes[1];
            cur = next;
        }
        return dummy.next;
    }

    public static ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode end = tail.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        head.next = null;
        return new ListNode[]{dummy.next, head};
    }
}
