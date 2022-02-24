import datastruct.ListNode;
import utils.Utils;

public class L000024 extends Template {

    public static void main(String[] args) {
//        ListNode r = swapPairs(Utils.makeListNode(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
