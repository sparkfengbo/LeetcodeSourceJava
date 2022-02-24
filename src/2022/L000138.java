import java.util.HashMap;
import java.util.Map;

public class L000138 extends Template {

    public static void main(String[] args) {
    }

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

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node/*old*/, Node/*copy*/> cache = new HashMap<>();
        Node dummyHead = new Node(1);
        Node current = head;
        Node copyPre = dummyHead;

        while (current != null) {
            Node copyCurrent = new Node(current.val);
            if (cache.containsKey(current)) {
                copyCurrent = cache.get(current);
            } else {
                copyCurrent = new Node(current.val);
                cache.put(current, copyCurrent);
            }
            if (current.random != null) {
                //是否存在random的新建Node
                if (cache.containsKey(current.random)) {
                    copyCurrent.random = cache.get(current.random);
                } else{
                    Node copyRandom = new Node(current.random.val);
                    copyCurrent.random = copyRandom;
                    cache.put(current.random, copyRandom);
                }
            }
            copyPre.next = copyCurrent;
            copyPre = copyPre.next;
            current = current.next;
        }
        return dummyHead.next;
    }
}
