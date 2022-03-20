import java.util.*;

public class LeetCode139_单词拆分 {


    /**
     * 字典树 + dfs
     *
     * https://leetcode-cn.com/problems/word-break/solution/geekplayes-leetcode-ac-qing-xi-yi-dong-d-vwbu/
     */
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict == null || wordDict.size() == 0) {
                return false;
            }

            Trie trie = new Trie();
            for (String word : wordDict) {
                trie.insertWord(word);
            }
            return trie.find(s, 0);
        }

        private class Trie {
            String word;
            Map<Character, Trie> map;
            boolean[] fail = new boolean[301];

            public Trie() {
                word = "";
                map = new HashMap<>();
            }

            public void insertWord(String word) {
                Trie cur = this;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (!cur.map.containsKey(ch)) {
                        cur.map.put(ch, new Trie());
                    }
                    cur = cur.map.get(ch);
                }
                cur.word = word;
            }

            public boolean find(String s, int start) {
                if (fail[start]) {
                    return false;
                }
                if (start == s.length()) {
                    return true;
                }
                Trie curr = this;
                for (int i = start; i < s.length(); i++) {
                    if (curr.map.containsKey(s.charAt(i))) {
                        curr = curr.map.get(s.charAt(i));
                        if (!curr.word.isEmpty() && find(s, i + 1)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
                fail[start] = true;
                return false;
            }
        }
    }


    /**
     * dp[i] : s[0:i] can word break => target: dp[n-1]
     * dp[i] = true if  s[0 : i] in wordlist
     * or  any dp[j] && s[j + 1 : i] in wordlist  0 <= j < i
     * <p>
     * dp[0] = s[0] in worldlist
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = wordDictSet.contains(s.substring(0, 1));
        for (int i = 1; i < n; i++) {
            if (wordDictSet.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    boolean isMatch = wordDictSet.contains(s.substring(j + 1, i + 1));
                    dp[i] = dp[j] && isMatch;
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 执行用时 : 30 ms , 在所有 Java 提交中击败了 5.19% 的用户
     * 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了 63.33% 的用户
     *
     * @param args
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int n = s.length();
//
//        boolean[] dp = new boolean[n];
//        dp[0] = isInWordList(s.substring(0, 1), wordDict);
//        for (int i = 1; i < n; i++) {
//            if (isInWordList(s.substring(0, i + 1), wordDict)) {
//                dp[i] = true;
//            } else {
//                for (int j = 0; j < i; j++) {
//                    boolean isMatch = isInWordList(s.substring(j + 1, i + 1), wordDict);
//                    dp[i] = dp[j] && isMatch;
//                    if (dp[i]) {
//                        break;
//                    }
//                }
//            }
//        }
//        return dp[n - 1];
//    }
//
//    private static boolean isInWordList(String s, List<String> wordDict) {
//        boolean isMatch = false;
//        for (String pattern : wordDict) {
//            if (pattern.equals(s)) {
//                isMatch = true;
//                break;
//            }
//        }
//        return isMatch;
//    }
    public static void main(String[] args) {
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        System.out.println(wordBreak("leetcode", wordDict));
//
//        wordDict.clear();
//        wordDict.add("apple");
//        wordDict.add("pen");
//        System.out.println(wordBreak("applepenapple", wordDict));
//
//        wordDict.clear();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
//        System.out.println(wordBreak("catsandog", wordDict));

        Solution solution = new Solution();

        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(solution.wordBreak("aaaaaaa", wordDict));
    }
}
