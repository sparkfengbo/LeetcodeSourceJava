import datastruct.ListNode;

public class L000082 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = head;
        ListNode pre = dummyNode;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = cur.next;
                while (p != null && p.val == cur.val) {
                    p = p.next;
                }
                pre.next = p;
                cur  = p;
            }
        }
        return dummyNode.next;
    }
}
