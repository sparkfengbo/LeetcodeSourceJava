import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LeetCode460 {

    public static void main(String[] args) {

    }

    static class LFUCache {
        private static class Node implements Comparable<Node> {
            int cnt, time, key, value;

            public Node(int cnt, int time, int key, int value) {
                this.cnt = cnt;
                this.time = time;
                this.key = key;
                this.value = value;
            }

            @Override
            public int hashCode() {
                return cnt * 1000000007 + time;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Node) {
                    Node rhs = (Node) obj;
                    return this.cnt == rhs.cnt && this.time == rhs.time;
                }
                return false;
            }

            @Override
            public int compareTo(Node o) {
                return cnt == o.cnt ? time - o.time : cnt - o.cnt;
            }

        }

        private int capacity, time;
        private Map<Integer, Node> key_table;
        private TreeSet<Node> S;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.time = 0;
            key_table = new HashMap<>();
            S = new TreeSet<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!key_table.containsKey(key)) {
                return -1;
            }
            Node e = key_table.get(key);
            S.remove(e);
            e.cnt += 1;
            e.time = ++time;
            S.add(e);
            key_table.put(key, e);
            return e.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!key_table.containsKey(key)) {
                // 如果到达缓存容量上限
                if (key_table.size() == capacity) {
                    // 从哈希表和平衡二叉树中删除最近最少使用的缓存
                    key_table.remove(S.first().key);
                    S.remove(S.first());
                }
                // 创建新的缓存
                Node cache = new Node(1, ++time, key, value);
                // 将新缓存放入哈希表和平衡二叉树中
                key_table.put(key, cache);
                S.add(cache);
            } else {
                // 这里和 get() 函数类似
                Node cache = key_table.get(key);
                S.remove(cache);
                cache.cnt += 1;
                cache.time = ++time;
                cache.value = value;
                S.add(cache);
                key_table.put(key, cache);
            }
        }
    }
}
