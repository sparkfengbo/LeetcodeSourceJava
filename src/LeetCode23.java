import datastruct.ListNode;

import java.util.ListIterator;

public class LeetCode23 {

    public static void main(String[] args) {
        ListNode[] test = new ListNode[3];
        test[0] = new ListNode(1);
        test[0].next = new ListNode(4);
        test[0].next.next = new ListNode(5);

        test[1] = new ListNode(1);
        test[1].next = new ListNode(3);
        test[1].next.next = new ListNode(4);

        test[2] = new ListNode(2);
        test[2].next = new ListNode(6);

        ListNode result = mergeKLists(test);
        System.out.println("result");
    }

    /**
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        int len = lists.length;
        ListNode dummpyNode = new ListNode(-1);

        int min = Integer.MAX_VALUE, nextMin = Integer.MAX_VALUE;
        ListNode current = dummpyNode;

        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                min = Math.min(min, lists[i].val);
            }
        }

        boolean quit = false;
        while (!quit) {
            boolean hasUpdate = false;
            for (int i = 0; i < len; i++) {
                while (lists[i] != null && lists[i].val == min) {
                    current.next = lists[i];
                    current = current.next;
                    lists[i] = lists[i].next;
                    hasUpdate = true;
                }
                if (lists[i] != null) {
                    nextMin = Math.min(nextMin, lists[i].val);
                }
                if (i == len - 1) {
                    min = Math.min(min + 1, nextMin);
                    nextMin = Integer.MAX_VALUE;
                    if (!hasUpdate) {
                        quit = true;
                    }
                }
            }
        }
        return dummpyNode.next;
    }
}
