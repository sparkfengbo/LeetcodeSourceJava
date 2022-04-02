import datastruct.Node;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode116_填充每个节点的下一个右侧节点指针 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Solution {
        public Node connect(Node root) {
            if(root == null) {
                return root;
            }
            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                for (int i = 0; i < curSize; i++) {
                    Node n = queue.poll();
                    if (i != curSize - 1) {
                        n.next = queue.peek();
                    }
                    if (n.left != null) {
                        queue.offer(n.left);
                    }
                    if (n.right != null) {
                        queue.offer(n.right);
                    }
                }
            }
            return root;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 空间复杂度 O(1)
     */
    class Solution_O1 {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

            // 从根节点开始
            Node leftmost = root;

            while (leftmost.left != null) {

                // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
                Node head = leftmost;

                while (head != null) {

                    // CONNECTION 1
                    head.left.next = head.right;

                    // CONNECTION 2
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }

                    // 指针向后移动
                    head = head.next;
                }

                // 去下一层的最左的节点
                leftmost = leftmost.left;
            }

            return root;
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        Node res = solution.connect(new Node(1));
        System.out.println();
    }
}
