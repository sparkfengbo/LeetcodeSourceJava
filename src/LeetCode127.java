import java.util.*;

public class LeetCode127 {
    public static class Solution {
        Map<String, Integer> wordId = new HashMap<>();
        List<List<Integer>> edge = new ArrayList<>();
        int nodeNum = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);
            if (!wordId.containsKey(endWord)) {
                return 0;
            }

            int[] dis = new int[nodeNum];
            Arrays.fill(dis, Integer.MAX_VALUE);
            int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
            dis[beginId] = 0;

            Queue<Integer> que = new LinkedList<>();
            que.offer(beginId);

            while (!que.isEmpty()) {
                int x = que.poll();
                if (x == endId) {
                    return dis[endId] / 2 + 1;
                }

                for (int it : edge.get(x)) {
                    if (dis[it] == Integer.MAX_VALUE) {
                        dis[it] = dis[x] + 1;
                        que.offer(it);
                    }
                }
            }
            return 0;
        }

        public void addEdge(String word) {
            addWord(word);
            int id1 = wordId.get(word);
            char[] array = word.toCharArray();
            int length = array.length;
            for (int i = 0; i < length; i++) {
                char tmp = array[i];
                array[i] = '*';
                String newWord = new String(array);
                addWord(newWord);
                int id2 = wordId.get(newWord);
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);
                array[i] = tmp;
            }

        }

        public void addWord(String word) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, nodeNum++);
                edge.add(new ArrayList<>());
            }
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ladderLength("hit", "cog", new ArrayList<String>() {
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
                add("cog");
            }
        }));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<MyNode> queue = new LinkedList<>();
        queue.offerLast(new MyNode(beginWord, new ArrayList<>()));
        int count = 0;
        while (!queue.isEmpty()) {
            MyNode node = queue.pollFirst();
            if (node.used.size() == wordList.size()) {
                continue;
            }
//            System.out.println(node.current);
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);
                if (!node.used.contains(i) && oneDifferent(node.current, word)) {
                    List<Integer> list = new ArrayList<>(node.used);
                    list.add(i);
                    queue.offerLast(new MyNode(word, list));
//                    for(Integer integer: list) {
//                        System.out.print(wordList.get(integer));
//                    }
//                    System.out.println();
                    if (word.equals(endWord)) {
                        return list.size() + 1;
                    }
                }
            }
        }
        return count;
    }

    private static final class MyNode {
        String current;
        List<Integer> used;

        public MyNode(String current, List<Integer> used) {
            this.current = current;
            this.used = used;
        }
    }

    private static boolean oneDifferent(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

}
