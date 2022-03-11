
import javafx.util.Pair;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;
import utils.Utils;

import java.util.*;


public class LeetCode126 {
    public static void main(String[] args) {
        Solution_Leetcode solution = new Solution_Leetcode();
        Utils.printNestList(solution.findLadders("hit", "cog", new ArrayList<String>() {
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
                add("cog");
            }
        }));

//        Utils.printNestList(solution.findLadders("a", "c", new ArrayList<String>() {
//            {
//                add("a");
//                add("b");
//                add("c");
//
//            }
//        }));
        System.out.println();
    }

    /**
     * https://leetcode-cn.com/problems/word-ladder-ii/solution/dan-ci-jie-long-ii-by-leetcode-solution/
     */
    static class Solution_Leetcode {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            // 因为需要快速判断扩展出的单词是否在 wordList 里，因此需要将 wordList 存入哈希表，这里命名为「字典」
            Set<String> dict = new HashSet<>(wordList);
            // 特殊用例判断
            if (!dict.contains(endWord)) {
                return res;
            }

            dict.remove(beginWord);

            // 第 1 步：广度优先遍历建图
            // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先遍历的第几层
            Map<String, Integer> steps = new HashMap<>();
            steps.put(beginWord, 0);
            // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
            Map<String, List<String>> from = new HashMap<>();
            int step = 1;
            boolean found = false;
            int wordLen = beginWord.length();
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String currWord = queue.poll();
                    char[] charArray = currWord.toCharArray();
                    // 将每一位替换成 26 个小写英文字母
                    for (int j = 0; j < wordLen; j++) {
                        char origin = charArray[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            charArray[j] = c;
                            String nextWord = String.valueOf(charArray);
                            if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                                from.get(nextWord).add(currWord);
                            }
                            if (!dict.contains(nextWord)) {
                                continue;
                            }
                            // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                            dict.remove(nextWord);
                            // 这一层扩展出的单词进入队列
                            queue.offer(nextWord);

                            // 记录 nextWord 从 currWord 而来
                            from.putIfAbsent(nextWord, new ArrayList<>());
                            from.get(nextWord).add(currWord);
                            // 记录 nextWord 的 step
                            steps.put(nextWord, step);
                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                        charArray[j] = origin;
                    }
                }
                step++;
                if (found) {
                    break;
                }
            }

            // 第 2 步：深度优先遍历找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
            if (found) {
                Deque<String> path = new ArrayDeque<>();
                path.add(endWord);
                dfs(from, path, beginWord, endWord, res);
            }
            return res;
        }

        public void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
            if (cur.equals(beginWord)) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (String precursor : from.get(cur)) {
                path.addFirst(precursor);
                dfs(from, path, beginWord, precursor, res);
                path.removeFirst();
            }
        }
    }

    static class Solution {
        Map<String, Integer> wordIds = new HashMap<>();
        Map<Integer, String> idWord = new HashMap<>();
        int wordNum = 0;
        List<List<Integer>> edge = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int currLength = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return res;
            }
            addEdge(beginWord);
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).equals(beginWord)) {
                    continue;
                }
                addEdge(wordList.get(i));
            }


            int[] dis = new int[wordNum];
            Arrays.fill(dis, Integer.MAX_VALUE);
            int beginId = wordIds.get(beginWord), endId = wordIds.get(endWord);
            dis[beginId] = 0;

            Queue<Pair<Integer, List<String>>> queue = new LinkedList<>();
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            queue.offer(new Pair<Integer, List<String>>(beginId, path));

            while (!queue.isEmpty()) {
                Pair<Integer, List<String>> kv = queue.poll();
                int x = kv.getKey();
                if (x == endId) {
                    min = kv.getValue().size();
                    List<String> mPath = new ArrayList(kv.getValue());
                    res.add(mPath);
                }
                for (int it : edge.get(x)) {
                    if (dis[it] == Integer.MAX_VALUE) {
                        dis[it] = dis[x] + 1;
                        List<String> mPath = new ArrayList(kv.getValue());
//                        if (idWord.containsKey(it)) {
                        mPath.add(idWord.get(it));
//                        }
                        Pair<Integer, List<String>> p = new Pair(it, mPath);
                        queue.offer(p);
                    }
                }
            }
            return res;
        }

        public List<List<String>> findLadders_dfs(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return res;
            }
            addEdge(beginWord);
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).equals(beginWord)) {
                    continue;
                }
                addEdge(wordList.get(i));
            }

            int beginId = wordIds.get(beginWord);
            int endId = wordIds.get(endWord);
            boolean[] visited = new boolean[wordNum];
            visited[beginId] = true;
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            dfs(beginId, endId, path, visited);
            return res;
        }

        public void dfs(int index, int endIndex, List<String> path, boolean[] visited) {
            if (index == endIndex) {
                if (res.size() > 0) {
                    if (path.size() < currLength) {
                        res.clear();
                        res.add(new ArrayList<>(path));
                        currLength = path.size();
                        return;
                    } else if (path.size() == currLength) {
                        res.add(new ArrayList<>(path));
                    }
                } else {
                    res.add(new ArrayList<>(path));
                    currLength = path.size();
                }
                return;
            }
            List<Integer> edgeList = edge.get(index);
            for (int i = 0; i < edgeList.size(); i++) {
                int id = edgeList.get(i);
                if (visited[id] || path.size() >= currLength) {
                    continue;
                }
                visited[id] = true;
                if (idWord.containsKey(id)) {
                    path.add(idWord.get(id));
                }
                dfs(id, endIndex, path, visited);
                if (idWord.containsKey(id)) {
                    path.remove(path.size() - 1);
                }
                visited[id] = false;
            }
        }

        public void addEdge(String word) {
            addWord(word);
            int id1 = wordIds.get(word);
            char[] arr = word.toCharArray();
            idWord.put(id1, word);
            for (int i = 0; i < word.length(); i++) {
                char tmp = arr[i];
                arr[i] = '*';
                String nWord = new String(arr);
                addWord(nWord);
                int id2 = wordIds.get(nWord);
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);
                arr[i] = tmp;
            }
        }

        public void addWord(String word) {
            if (!wordIds.containsKey(word)) {
                wordIds.put(word, wordNum++);
                edge.add(new ArrayList<>());
            }
        }
    }

}
