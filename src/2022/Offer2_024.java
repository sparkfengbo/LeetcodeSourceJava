import datastruct.ListNode;
import utils.Utils;

public class Offer2_024 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head, cur = head.next;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = null;
        return prev;
    }
}
