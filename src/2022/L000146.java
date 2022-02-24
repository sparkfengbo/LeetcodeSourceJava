import datastruct.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class L000146 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    static class LRUCache {
        private static class Node<K, V> {
            Node before, after;
            K key;
            V val;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, Node<Integer, Integer>> map;
        private int capacity;
        private Node dummyHead, dummyTail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>(capacity);
            dummyHead = new Node(-1, -1);
            dummyTail = new Node(-1, -1);
            dummyHead.after = dummyTail;
            dummyTail.before = dummyHead;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node<Integer, Integer> e = map.get(key);
                e.before.after = e.after;
                e.after.before = e.before;

                appendTail(e);
                return e.val;
            }

            return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                Node<Integer, Integer> e = map.get(key);
                e.val = value;

                e.before.after = e.after;
                e.after.before = e.before;

                appendTail(e);
                return;
            }

            if (capacity == map.size()) {
                Node r = dummyHead.after;
                dummyHead.after.after.before = dummyHead;
                dummyHead.after = dummyHead.after.after;
                map.remove(r.key);
            }
            Node<Integer, Integer> e = new Node<>(key, value);
            //放到队尾
            appendTail(e);
            map.put(key, e);
        }

        private void appendTail(Node e) {
            e.before = dummyTail.before;
            e.after = dummyTail;
            dummyTail.before.after = e;
            dummyTail.before = e;
        }
    }
}
