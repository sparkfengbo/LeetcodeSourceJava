import datastruct.ListNode;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class L000143 extends Template {

    public static void main(String[] args) {
        ListNode head= Utils.makeListNode(new int[]{1,2,3,4,5});
        reorderList(head);
        System.out.println();
    }

    public static void reorderList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();

        ListNode cur = head;
        while (cur!= null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while(cur != stack.peek() && cur.next.next != null) {
            //保留尾部节点的pre节点，这样方便断链操作
            ListNode node = stack.pop();
            ListNode pre = stack.peek();
            pre.next = null;
            ListNode next = cur.next;
            node.next = next;
            cur.next = node;
            cur = next;
        }
    }
}
