import datastruct.ListNode;
import utils.Utils;

import java.util.List;


public class L000023 extends Template {

    public static void main(String[] args) {
        ListNode node1= new ListNode(1);
//        ListNode[] test =new ListNode[]{
//                Utils.makeListNode(new int[]{1, 4 ,5}),
//                Utils.makeListNode(new int[]{1, 3, 4}),
//                Utils.makeListNode(new int[]{2, 6})
//        };
//        ListNode r = mergeKLists(test);

        ListNode[] test =new ListNode[]{
                Utils.makeListNode(new int[]{-2,1,4,5}),
                Utils.makeListNode(new int[]{-2,5,6}),
                Utils.makeListNode(new int[]{-2,0})
        };
        ListNode r = mergeKLists(test);
        System.out.println(r.val);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        if (lists.length == 0) {
            return null;
        }

        while (true) {
            for (int i = 0; i < lists.length; i++) {
                ListNode head = lists[i];
                if (head == null) {
                    continue;
                }
                ListNode p = dummy;
                while (p.next != null && p.next.val <= head.val) {
                    p = p.next;
                }
                ListNode next = head.next;
                head.next = p.next;
                p.next = head;
                lists[i] = next;
            }

            boolean isAll = true;
            for (int i = 0; i < lists.length; i++) {
                ListNode head = lists[i];
                if (head != null) {
                    isAll = false;
                    break;
                }
            }
            if (isAll) break;
        }
        return dummy.next;
    }
}
