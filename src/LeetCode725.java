import datastruct.ListNode;
import datastruct.TreeNode;

public class LeetCode725 {

    public static void main(String[] args) {
        //1, 2, 3
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        ListNode[] r = splitListToParts(test, 5);


        test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        test.next.next.next.next.next = new ListNode(6);
        test.next.next.next.next.next.next = new ListNode(7);
        test.next.next.next.next.next.next.next = new ListNode(8);
        test.next.next.next.next.next.next.next.next = new ListNode(9);
        test.next.next.next.next.next.next.next.next.next = new ListNode(10);
        r = splitListToParts(test, 3);
        System.out.print("");
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) {
            return result;
        }

        //链表长度
        int len = 0;
        ListNode node = root;
        while (node != null) {
            node = node.next;
            len++;
        }

        //统计基本个数
        int count = len / k;

        //剩余均分到其他的链表中
        int leftCount = len % k;

        node = root;
        for (int i = 0, j = 1; i < k && node != null; i++, j = 1) {
            ListNode itemRoot = node;
            int tmp = count;
            if (i < leftCount) {
                tmp += 1;
            }
            while (node != null && j < tmp) {
                node = node.next;
                j++;
            }
            ListNode next = node.next;
            node.next = null;
            node = next;
            result[i] = itemRoot;
        }
        return result;
    }
}
