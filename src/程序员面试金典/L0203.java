package 程序员面试金典;

import datastruct.ListNode;

public class L0203 {
    public static void main(String[] args) {
        System.out.println();

    }



    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode pre = node;
        while (cur.next != null) {
            cur.val = cur.next.val;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;

    }
}
