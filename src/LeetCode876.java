import datastruct.ListNode;

import java.util.ArrayList;

/**
 * 链表的中间结点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 datastruct.ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class LeetCode876 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode result = middleNode(root);
        System.out.println(result.val);
    }

    public static ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head.next;
        }


        ArrayList<ListNode> list = new ArrayList<>(51);

        ListNode tmp = head;

        int count = 0;

        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
            count++;
        }
        return list.get(count / 2);
    }
}
