import java.util.*;

public class LeetCode133 {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {


    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution_dfs {
        private HashMap<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }

            // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
            Node cloneNode = new Node(node.val, new ArrayList());
            // 哈希表存储
            visited.put(node, cloneNode);

            // 遍历该节点的邻居并更新克隆节点的邻居列表
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution_bfs {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }

            HashMap<Node, Node> visited = new HashMap();

            // 将题目给定的节点添加到队列
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(node);
            // 克隆第一个节点并存储到哈希表中
            visited.put(node, new Node(node.val, new ArrayList()));

            // 广度优先搜索
            while (!queue.isEmpty()) {
                // 取出队列的头节点
                Node n = queue.remove();
                // 遍历该节点的邻居
                for (Node neighbor : n.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        // 如果没有被访问过，就克隆并存储在哈希表中
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                        // 将邻居节点加入队列中
                        queue.add(neighbor);
                    }
                    // 更新当前节点的邻居列表
                    visited.get(n).neighbors.add(visited.get(neighbor));
                }
            }

            return visited.get(node);
        }
    }


    class Solution {
        Map<Node, Node> cache = new HashMap<>();
        Set<Node> set = new HashSet<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Deque<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                if (!set.add(n)) {
                    continue;
                }
                Node copy = cloneNode(n);
                List<Node> neighbors = n.neighbors;
                for (int i = 0; i < neighbors.size(); i++) {
                    Node neighbor = neighbors.get(i);
                    queue.add(neighbor);
                    copy.neighbors.add(cloneNode(neighbor));
                }
            }
            return cache.get(node);
        }

        private Node cloneNode(Node node) {
            if (!cache.containsKey(node)) {
                Node copy = new Node(node.val);
                cache.put(node, copy);
            }
            return cache.get(node);
        }
    }

}
