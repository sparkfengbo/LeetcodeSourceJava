import datastruct.ListNode;

public class L000142 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

//    public static String getPermutation(int n, int k) {
//
//    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(true) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
