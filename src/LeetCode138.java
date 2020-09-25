import datastruct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node root0 = new Node(7);
        Node root1 = new Node(13);
        Node root2 = new Node(11);

        Node root3 = new Node(2);
        Node root4 = new Node(1);

        root0.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;

        root1.random = root0;
        root2.random = root4;
        root3.random = root2;
        root4.random = root0;

        Node ans = copyRandomList(root0);

        System.out.print("");
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node/*old*/, Node/*old*/> cache = new HashMap<>();

        Node dummyNode = new Node(01);
        Node copyPre = dummyNode;
        Node current = head, copyCurrent;
        while (current != null) {
            if (cache.containsKey(current)) {
                copyCurrent = cache.get(current);
            } else {
                copyCurrent = new Node(current.val);
                cache.put(current, copyCurrent);
            }
            copyPre.next = copyCurrent;
            copyPre = copyCurrent;
            if (current.random != null) {
                if (cache.containsKey(current.random)) {
                    copyCurrent.random = cache.get(current.random);
                } else {
                    copyCurrent.random = new Node(current.random.val);
                    cache.put(current.random, copyCurrent.random);
                }
            }
            //copy node
            current = current.next;
        }
        return dummyNode.next;
    }
}
