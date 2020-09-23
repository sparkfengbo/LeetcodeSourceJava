import datastruct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode147 {


    public static void main(String[] args) {
        //[4,2,1,3]
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);

        ListNode r = insertionSortList(root);
        System.out.println("end");
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head.next;
        dummy.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {// 本来就有序
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                // 找到一个位置使得p < cur < p.next
                while (p.next != cur && p.next.val < cur.val) {
                    p = p.next;
                }
                // 将cur插入到p和p.next之间
                // 因为cur被插到前面，pre的指针需要跳过cur
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                // 完成插入后，cur回到pre后面
                cur = pre.next;
            }
        }
        return dummy.next;

//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummyNode = new ListNode(-1);
//        ListNode dummyTail = dummyNode;
//        int currentMax = Integer.MIN_VALUE;
//        ListNode current = head;
//        while (current != null) {
//            ListNode next = current.next;
//
//            //inner loop
//            if (current == head) {
//                currentMax = Math.max(current.val, currentMax);
//                current.next = null;
//                dummyTail.next = current;
//                dummyTail = dummyTail.next;
//            } else {
//                if (current.val >= currentMax) {
//                    current.next = null;
//                    currentMax = Math.max(current.val, currentMax);
//                    dummyTail.next = current;
//                    dummyTail = dummyTail.next;
//                } else {
//                    ListNode dummyPre = dummyNode;
//                    ListNode dummyCurrent = dummyNode.next;
//                    while (dummyCurrent != null) {
//                        if (dummyCurrent.val > current.val) {
//                            current.next = null;
//                            dummyPre.next = current;
//                            current.next = dummyCurrent;
//                            break;
//                        } else {
//                            dummyPre = dummyCurrent;
//                            dummyCurrent = dummyCurrent.next;
//                        }
//                    }
//                }
//            }
//            current = next;
//        }
//
//
//        return dummyNode.next;
    }
}
