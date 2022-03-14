import sun.awt.image.ImageWatched;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;
import utils.Utils;

import java.util.*;

public class LeetCode212 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] booad = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}

//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}

                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}

        };

        Utils.printList(new Solution_Leetcode().findWords(booad, new String[]{
                "oath", "pea", "eat", "rain", "hklf", "hf"
        }));
    }

    static class Solution_Leetcode {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            Set<String> ans = new HashSet<String>();
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    dfs(board, trie, i, j, ans);
                }
            }

            return new ArrayList<String>(ans);
        }

        public void dfs(char[][] board, Trie curr, int r, int c, Set<String> ans) {
            if (!curr.children.containsKey(board[r][c])) {
                return;
            }
            char ch = board[r][c];
            curr = curr.children.get(ch);
            if (!"".equals(curr.word)) {
                ans.add(curr.word);
            }

            board[r][c] = '#';
            for (int[] dir : dirs) {
                int i = r + dir[0], j = c + dir[1];
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    dfs(board, curr, i, j, ans);
                }
            }
            board[r][c] = ch;
        }

        class Trie {
            String word;
            Map<Character, Trie> children;
            boolean isWord;

            public Trie() {
                this.word = "";
                this.children = new HashMap<Character, Trie>();
            }

            public void insert(String word) {
                Trie cur = this;
                for (int i = 0; i < word.length(); ++i) {
                    char c = word.charAt(i);
                    if (!cur.children.containsKey(c)) {
                        cur.children.put(c, new Trie());
                    }
                    cur = cur.children.get(c);
                }
                cur.word = word;
            }
        }
    }


    /**
     * 超时， 有个数据结构没搞好，如何将toFind保存下来
     */
    static class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            int m = board.length;
            int n = board[0].length;

            boolean[][] visited = new boolean[m][n];
            List<Integer> toFind = new ArrayList<>();
            Set<Integer> hasFind = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                toFind.add(i);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    backtrace(res, words, board, 0, toFind, i, j, visited, hasFind);
                }
            }

            return res;
        }

        private void backtrace(List<String> res, String[] words, char[][] board, int k, List<Integer> toFind, int r, int c, boolean[][] visited, Set<Integer> hasFind) {
            for (int i = 0; i < toFind.size(); i++) {
                int wordIndex = toFind.get(i);
                String s = words[wordIndex];
                if (k == s.length()) {
                    hasFind.add(wordIndex);
                    res.add(s);
                }
            }
            toFind.removeAll(hasFind);

            if (toFind.size() == 0) {
                return;
            }

            if (hasFind.size() == words.length) {
                return;
            }

            if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
                return;
            }

            if (visited[r][c]) {
                return;
            }


            int[][] direction = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
            };

            visited[r][c] = true;


            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < toFind.size(); i++) {
                int wordIndex = toFind.get(i);
                String s = words[wordIndex];
                if (board[r][c] != s.charAt(k)) {
                    tmp.add(wordIndex);
                }
            }
            toFind.removeAll(tmp);

            for (int i = 0; i < 4; i++) {
                backtrace(res, words, board, k + 1, toFind, r + direction[i][0], c + direction[i][1], visited, hasFind);
            }
            toFind.addAll(tmp);
            visited[r][c] = false;
        }
    }
}
