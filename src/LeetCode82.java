import datastruct.ListNode;

import java.util.HashSet;

/**
 * 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class LeetCode82 {

    public static void main(String[] args) {
//        datastruct.ListNode head = new datastruct.ListNode(1);
//        datastruct.ListNode node2 = new datastruct.ListNode(1);
//        head.next = node2;
//        datastruct.ListNode node3 = new datastruct.ListNode(2);
//        node2.next = node3;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(1);
        head2.next = node21;
        ListNode node31 = new ListNode(1);
        node21.next = node31;
        ListNode node41 = new ListNode(2);
        node31.next = node41;
        ListNode node51 = new ListNode(3);
        node41.next = node51;
        ListNode node61 = new ListNode(5689);
        node51.next = node61;


        ListNode result = deleteDuplicates(head2);

        System.out.println("");

    }

    class Solution {
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


    /**
     * 思路： 两边遍历
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tNode = head, tPrev = null, resultHead = null;
        HashSet<Integer> keys = new HashSet<>();

        while (tNode != null && tNode.next != null) {
            if (tNode.val == tNode.next.val) {
                keys.add(tNode.val);
                tNode = tNode.next.next;
            } else {
                tNode = tNode.next;
            }
        }


        tNode = head;
        while (tNode != null) {
            if (!keys.contains(tNode.val)) {
                //确定head的位置
                if (resultHead == null) {
                    //移除其他node对resultHead的引用
                    if (tPrev != null) {
                        tPrev.next = null;
                    }
                    resultHead = tNode;
                }
                tPrev = tNode;
                tNode = tNode.next;
            } else {
                if (tPrev != null) {
                    tPrev.next = tNode.next;
                }
                tNode = tNode.next;
            }
        }
        return resultHead;
    }


    /**
     * 思路：双指针
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyNode = new ListNode(-1);

        ListNode tail = dummyNode;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.next.val == pre.val)
                cur = cur.next;
            if (cur == pre) {
                tail.next = pre;
                tail = tail.next;
            }
            pre = cur.next;
            cur = cur.next;
        }
        tail.next = cur;
        return dummyNode.next;
//        if (head == null) return head;  // 若head为空则直接返回null
//        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
//        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
//        for (ListNode l = head, r = head; l != null; l = r) {
//            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
//            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
//                tail.next = l;  // 基本的尾插法
//                tail = l;
//                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
//            }
//        }
//        return dummy.next;
//
//        作者：optimjie
//        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/javashuang-zhi-zhen-dai-ma-jiao-duan-rong-yi-li-ji/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
