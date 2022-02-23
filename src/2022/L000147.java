import datastruct.ListNode;

public class L000147 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                while (p.next != cur && p.next.val <= cur.val) {
                    p = p.next;
                }
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}
