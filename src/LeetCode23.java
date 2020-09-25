import datastruct.ListNode;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class LeetCode23 {

    public static void main(String[] args) {
//        ListNode[] test = new ListNode[3];
//        test[0] = new ListNode(1);
//        test[0].next = new ListNode(4);
//        test[0].next.next = new ListNode(5);
//
//        test[1] = new ListNode(1);
//        test[1].next.next = new ListNode(4);
//
//        test[2] = new ListNode(2);
//        test[2].next = new ListNode(6);
//
////        ListNode result = mergeKLists(test);
////        result = mergeKLists2(test);
//        ListNode result = mergeKLists3(test);

        ListNode[] test2 = new ListNode[1];

        ListNode result = mergeKLists3(test2);

        System.out.println("result");
    }

    /**
     * 方法1 ： 两两合并
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    /**
     * 方法2 ： 分治法
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if(l > r) {
            return null;
        }
        if(l == r) {
            return lists[l];
        }
        int mid = (l + r) >>1;
//        int mid = l + (right - l) /2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 方法3：优先级队列
     */

    public static ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                }
                return 0;
            }


        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        while(!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;

            if (p.next != null) {
                queue.add(p.next);
            }
        }

        return dummyNode.next;
    }

}
