import datastruct.ListNode;
import utils.Utils;

public class L000086 extends Template {

    public static void main(String[] args) {

        ListNode r = partition(Utils.makeListNode(new int[]{1, 4, 3, 2, 5, 2}), 3);
        System.out.println(r);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur = head;
        ListNode pivot = null, prePivot = null;

        while (cur != null) {
            if (cur.val < x && pivot != null) {
                ListNode next = cur.next;
                //断链
                pre.next = next;
                cur.next = pivot;
                prePivot.next = cur;
                prePivot = cur;
                cur = next;
            } else if (pivot == null && cur.val >= x) {
                prePivot = pre;
                pivot = cur;
                pre = cur;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
