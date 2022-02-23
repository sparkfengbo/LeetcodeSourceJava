package 剑指Offer;

import datastruct.ListNode;

public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            nodeA = nodeA == null ? headB : nodeA.next;
            //指针tempB同上
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        //tempA要么是空，要么是两链表的交点
        return nodeA;
    }

    public static void main(String[] args) {
//        System.out.println(singleNumbers(new int[]{4,10,2,4}));
    }


}
