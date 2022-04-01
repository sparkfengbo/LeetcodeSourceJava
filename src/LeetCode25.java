import datastruct.ListNode;

public class LeetCode25 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);


//        ListNode ans = removeNthFromEnd(root, 2);
//        ListNode ans = removeNthFromEnd(root, 1);
//        ListNode ans = reverseKGroup(root, 2);
        ListNode ans = reverseKGroup(root, 5);

        System.out.print("");
    }

    class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) {
                return head;
            }
            ListNode dummy = new ListNode(0);

            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;

            while (cur != null) {
                int cnt = 1;
                while (cnt < k) {
                    cur = cur.next;
                    cnt++;
                    if (cur == null) {
                        return dummy.next;
                    }
                }
                ListNode next = cur.next;
                ListNode[] nodes = reverseList(pre.next, cur);
                pre.next = nodes[0];
                nodes[1].next = next;
                pre = nodes[1];
                cur = next;
            }
            return dummy.next;
        }

        public ListNode[] reverseList(ListNode head, ListNode tail) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = head.next;
            ListNode end = tail.next;
            while (cur != end) {
                ListNode next = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
                cur = next;
            }
            head.next = null;
            return new ListNode[]{dummy.next, head};
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode current = head, start = current, end = null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        int count = 1;

        while (current.next != null) {
            ListNode next = current.next;
            if (count == k) {
                ListNode[] r = reverseList(start, end);
                ListNode rHead = r[0], rtail = r[1];

                rtail.next = next;
                prev.next = rHead;
                prev = rtail;
                start = rtail.next;
                count = 0;
            }
            count++;
            current = next;
            end = current;
        }
        if (count == k) {
            ListNode[] r = reverseList(start, end);
            ListNode rHead = r[0], rtail = r[1];
            rtail.next = null;
            prev.next = rHead;
        }
        return dummyNode.next;
    }

    private static ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode prev = head;
        ListNode p = head.next;
        while (p != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        tail.next = prev;
        return new ListNode[]{tail, head};
    }
}
