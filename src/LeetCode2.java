import datastruct.ListNode;

/**
 * 两数相加
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode2 {

    public static void main(String[] args) {

//        datastruct.ListNode root1 = new datastruct.ListNode(2);
//        root1.next = new datastruct.ListNode(4);
//        root1.next.next = new datastruct.ListNode(3);
//
//        datastruct.ListNode root2 = new datastruct.ListNode(5);
//        root2.next = new datastruct.ListNode(6);
//        root2.next.next = new datastruct.ListNode(4);

        ListNode root1 = new ListNode(5);
        ListNode root2 = new ListNode(5);


//        datastruct.ListNode root1 = new datastruct.ListNode(9);
//
//        datastruct.ListNode root2 = new datastruct.ListNode(1);
//        root2.next = new datastruct.ListNode(9);
//        root2.next.next = new datastruct.ListNode(9);
//        root2.next.next.next = new datastruct.ListNode(9);
//        root2.next.next.next.next = new datastruct.ListNode(9);
//        root2.next.next.next.next.next = new datastruct.ListNode(9);
//        root2.next.next.next.next.next.next = new datastruct.ListNode(9);
//        root2.next.next.next.next.next.next.next = new datastruct.ListNode(9);
//        root2.next.next.next.next.next.next.next.next = new datastruct.ListNode(9);
//        root2.next.next.next.next.next.next.next.next.next = new datastruct.ListNode(9);

        ListNode result = addTwoNumbers(root1, root2);
        System.out.println();
    }

    /**
     * 需要考虑溢出的情况，所以断不能使用Integer相加
     * <p>
     * 思路：遍历节点，相加，进位最多为1，需要考虑进位问题
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prevResultHead = new ListNode(-1);

        ListNode curNode = prevResultHead;

        boolean carry = false;

        while (l1 != null || l2 != null) {
            int temp = 0;

            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }

            if (carry) {
                temp += 1;
            }

            if (temp / 10 >= 1) {
                carry = true;
            } else {
                carry = false;
            }
            ListNode node = new ListNode(temp % 10);
            curNode.next = node;
            curNode = curNode.next;
        }

        if (carry) {
            curNode.next = new ListNode(1);
        }
        return prevResultHead.next;
    }

}
