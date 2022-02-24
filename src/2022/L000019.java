import datastruct.ListNode;
import utils.Utils;

public class L000019 extends Template {

    public static void main(String[] args) {
        ListNode r = removeNthFromEnd(Utils.makeListNode(new int[]{1, 2, 3, 4, 5}), 2);
//        r = removeNthFromEnd(Utils.makeListNode(new int[]{1, 2 }), 2);
//        r = removeNthFromEnd(Utils.makeListNode(new int[]{1, 2 }), 1);
        r = removeNthFromEnd(Utils.makeListNode(new int[]{1}), 1);
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
