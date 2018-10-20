import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class LeetCode61 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode result = rotateRight(root, 2);



//        datastruct.ListNode root1 = new datastruct.ListNode(0);
//        root1.next = new datastruct.ListNode(1);
//        root1.next.next = new datastruct.ListNode(2);
//
//        datastruct.ListNode result = rotateRight(root1, 4);

        System.out.println();
    }


    /**
     * 思路，不移动指针，只是把val重新赋值
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        int length = 1;

        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        current.next = head;

        ListNode finalHead = head;

        int finalIndex =  length - k % length + 1;
//        System.out.println(finalIndex);
        for (int i = 1; i < finalIndex; i++) {
            if (i == finalIndex - 1) {
                ListNode node = finalHead;
                finalHead = finalHead.next;
                node.next = null;
                break;
            }
            finalHead = finalHead.next;
        }

        return finalHead;
    }


    /**
     * 用ArrayList存储，但是会超内存限制....
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight1(ListNode head, int k) {

        if (k == 0) {
            return head;
        }
        ListNode current = head;

        List<ListNode> nodeList = new ArrayList<>();

        while (current != null) {
            nodeList.add(current);
            current = current.next;
        }
        int length = nodeList.size();
        ListNode rotateHead = nodeList.get(length - k % length);
        nodeList.get(length - 1).next = head;
        return rotateHead;
    }
}
