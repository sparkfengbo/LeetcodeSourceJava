import datastruct.ListNode;

public class LeetCode24 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);


//        ListNode ans = removeNthFromEnd(root, 2);
//        ListNode ans = removeNthFromEnd(root, 1);
        ListNode ans = swapPairs(root);

        System.out.print("");
    }


    public static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        ListNode first, second, prev, current  = head;
        ListNode dummyNode = new ListNode(0);
        prev = dummyNode;
        while (current != null && current.next != null) {
            first = current;
            second = current.next;
            current = current.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return dummyNode.next;


        //递归解法
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode next = head.next;
//        head.next = swapPairs(next.next);
//        next.next = head;
//        return next;
    }
}
