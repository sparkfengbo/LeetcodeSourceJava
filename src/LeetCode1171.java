import datastruct.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1171 {

    /**
     * 执行用时： 60 ms , 在所有 Java 提交中击败了 5.59% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 57.85% 的用户
     * @param head
     * @return
     */
    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null || (head.next == null && head.val == 0)) {
            return null;
        }

        ListNode[] array = new ListNode[1000];
        ListNode current = head;
        int index = 0;
        while (current != null) {
            array[index] = current;
            index++;
            current = current.next;
        }
        HashMap<Integer/*start*/, Integer/*target*/> sumCache = new HashMap<>();

        for (index = 0; index < array.length && array[index] != null; index++) {
            //先判断是否符合标准
            int target = array[index].val;
            if (sumCache.values().contains(target)) {
                int startIndex = array.length;
                for (Map.Entry<Integer/*start*/, Integer/*target*/> entry : sumCache.entrySet()) {
                    if (entry.getValue() == target) {
                        startIndex = entry.getKey();
                        break;
                    }
                }
                for (int i = startIndex; i <= index; i++) {
                    array[i] = null;
                    sumCache.remove(i);
                }
                //更新target
                for (Map.Entry<Integer/*start*/, Integer/*target*/> entry : sumCache.entrySet()) {
                    int val = entry.getValue() - target;
                    entry.setValue(val);
                }
            } else {
                if (array[index].val == 0) {
                    array[index] = null;
                } else {
                    //没有的话跟新
                    for (Map.Entry<Integer/*start*/, Integer/*target*/> entry : sumCache.entrySet()) {
                        int val = entry.getValue() - array[index].val;
                        entry.setValue(val);
                    }
                    sumCache.put(index, -array[index].val);
                }
            }
        }

        ListNode dummyHead = new ListNode(0);
        current = dummyHead;
        for (index = 0; index < array.length; index++) {
            if (array[index] != null) {
                current.next = new ListNode(array[index].val);
                current = current.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
//        ListNode root = new ListNode(1);
//        root.next = new ListNode(2);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(-3);
//        root.next.next.next.next = new ListNode(4);
//        ListNode r = removeZeroSumSublists(root);

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(-3);
        root.next.next.next.next = new ListNode(-2);
        ListNode r = removeZeroSumSublists(root);
        System.out.print("");
    }
}
