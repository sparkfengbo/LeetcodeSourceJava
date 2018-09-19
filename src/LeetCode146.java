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

        private HashMap<Integer, Integer> mMaps;
        private int max;

        public LRUCache(int capacity) {
            max = capacity;
            mMaps = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true);
        }

        public int get(int key) {
            Integer result = mMaps.get(key);
            return result != null ? result : -1;
        }

        public void put(int key, int value) {
            if (mMaps.size() >= max && mMaps.get(key) == null) {
                for (Map.Entry<Integer, Integer> entry : mMaps.entrySet()) {
                    mMaps.remove(entry.getKey());
                    if (mMaps.size() < max) {
                        break;
                    }
                }
            }
            mMaps.put(key, value);
        }
    }

}
