import datastruct.ListNode;

import java.util.Stack;

public class LeetCode445 {

    public static void main(String[] args) {

        datastruct.ListNode root1 = new datastruct.ListNode(7);
        root1.next = new datastruct.ListNode(2);
        root1.next.next = new datastruct.ListNode(4);
        root1.next.next.next = new datastruct.ListNode(3);

        datastruct.ListNode root2 = new datastruct.ListNode(5);
        root2.next = new datastruct.ListNode(6);
        root2.next.next = new datastruct.ListNode(4);

        ListNode result = addTwoNumbers(root1, root2);
        System.out.println(result.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> stackFinal = new Stack<>();

        ListNode node = l1;
        while (node.next != null) {
            stack1.push(node);
            node = node.next;
        }
        stack1.push(node);

        node = l2;
        while (node.next != null) {
            stack2.push(node);
            node = node.next;
        }
        stack2.push(node);
        boolean carry = false;
        while (!stack1.empty() || !stack2.empty()) {
            int tmp = 0;
            if (!stack1.empty()) {
                node = stack1.pop();
                tmp += node.val;
            }

            if (!stack2.empty()) {
                node = stack2.pop();
                tmp += node.val;
            }

            if (carry) {
                tmp += 1;
            }

            if (tmp / 10 >= 1)
                carry = true;
            else
                carry = false;

            stackFinal.push(new ListNode(tmp % 10));
        }

        if (carry) {
            stackFinal.push(new ListNode(1));
        }

        ListNode ans = new ListNode(0);
        node = ans;
        while (!stackFinal.isEmpty()) {
            node.next = new ListNode(stackFinal.pop().val);
            node = node.next;
        }
        return ans.next;
    }

}
