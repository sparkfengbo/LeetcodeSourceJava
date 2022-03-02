package 剑指Offer;

import datastruct.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Offer30 {

    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> cache = new HashMap<>();
        Node dummy = new Node(1);
        Node pre = dummy;
        Node curr = head;

        while (curr != null) {
            Node copyCurr;
            if (cache.containsKey(curr)) {
                copyCurr = cache.get(curr);
            } else {
                copyCurr = new Node(curr.val);
                cache.put(curr, copyCurr);
            }

            Node random = curr.random;
            if (random != null) {
                Node copyRandom;
                if (cache.containsKey(random)) {
                    copyRandom = cache.get(random);
                } else {
                    copyRandom = new Node(random.val);
                    cache.put(random, copyRandom);
                }
                copyCurr.random = copyRandom;
            }

            pre.next = copyCurr;
            pre = pre.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
