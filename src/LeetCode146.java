import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LeetCode146 {


    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));           // 返回  1
        cache.put(3, 3);                            // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));           // 返回 -1 (未找到)
        cache.put(4, 4);                            // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));           // 返回 -1 (未找到)
        System.out.println(cache.get(3));           // 返回  3
        System.out.println(cache.get(4));           // 返回  4
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    static class LRUCache {
        private static class Node<K,V> {
            Node before, after;
            K key;
            V val;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        private int capacity;
        private Map<Integer, Node<Integer, Integer>> mMaps;
        private Node dummyHead, dummyTail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            mMaps = new HashMap(capacity);
            dummyHead = new Node(-1, -1);
            dummyTail = new Node(-1, -1);
            dummyHead.after = dummyTail;
            dummyTail.before = dummyHead;
        }

        public int get(int key) {
            if (mMaps.containsKey(key)) {
                Node<Integer, Integer> e = mMaps.get(key);
                e.before.after = e.after;
                e.after.before = e.before;

                //放到队尾
                appendTail(e);
                return e.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (mMaps.containsKey(key)) {
                Node<Integer, Integer> e = mMaps.get(key);
                e.val = value;

                e.before.after = e.after;
                e.after.before = e.before;

                //放到队尾
                appendTail(e);
                return;
            }

            if (capacity == mMaps.size ()) {
                // 删除队首
                Node r = dummyHead.after;
                dummyHead.after.after.before = dummyHead;
                dummyHead.after = dummyHead.after.after;
                mMaps.remove(r.key);
            }

            Node<Integer, Integer> e = new Node<>(key, value);
            //放到队尾
            appendTail(e);
            mMaps.put(key, e);
        }

        private void appendTail(Node e){
            e.before = dummyTail.before;
            e.after = dummyTail;
            dummyTail.before.after = e;
            dummyTail.before = e;
        }
    }

}
