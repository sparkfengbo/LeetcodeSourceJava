
public class LeetCode117_填充每个节点的下一个右侧节点指针II {

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
            if (root == null) {
                return root;
            }
            Node leftmost = root;
            while (leftmost != null && (leftmost.left != null || leftmost.right != null)) {
                Node head = leftmost;
                while (head != null) {
                    if (head.left != null) {
                        if (head.right != null) {
                            head.left.next = head.right;
                        } else {
                            Node next = head.next;
                            while (next != null && next.left == null && next.right == null) {
                                next = next.next;
                            }
                            if (next != null) {
                                head.left.next = next.left != null ? next.left : next.right;
                            }
                        }
                    }

                    if (head.right != null) {
                        Node next = head.next;
                        while (next != null && next.left == null && next.right == null) {
                            next = next.next;
                        }
                        if (next != null) {
                            head.right.next = next.left != null ? next.left : next.right;
                        }
                    }

                    head = head.next;
                }

                leftmost = leftmost.left != null ? leftmost.left : leftmost.right;
                while (leftmost != null && leftmost.left == null && leftmost.right == null) {
                    leftmost = leftmost.next;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        solution.connect(root);
    }
}
