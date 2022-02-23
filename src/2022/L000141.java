import datastruct.ListNode;

public class L000141 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

//    public static String getPermutation(int n, int k) {
//
//    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
