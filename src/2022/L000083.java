import datastruct.ListNode;

public class L000083 extends Template {

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

        while (cur.next != null) {
            if(cur.val != cur.next.val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return dummyNode.next;
    }
}
