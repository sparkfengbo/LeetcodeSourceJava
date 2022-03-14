import datastruct.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode208 {
    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }


//    class Trie {
//        String word = "";
//        Map<Character, Trie> cache;
//
//        public Trie() {
//            cache = new HashMap<>();
//        }
//
//        public void insert(String word) {
//            char[] arr = word.toCharArray();
//            Trie cur = this;
//            for (int i = 0; i < arr.length; i++) {
//                if (!cur.cache.containsKey(arr[i])) {
//                    cur.cache.put(arr[i], new Trie());
//                }
//                cur = cur.cache.get(arr[i]);
//            }
//            cur.word = word;
//        }
//
//        public boolean search(String word) {
//            char[] arr = word.toCharArray();
//            Trie cur = this;
//            for (int i = 0; i < arr.length; i++) {
//                if (!cur.cache.containsKey(arr[i])) {
//                    return false;
//                }
//                cur = cur.cache.get(arr[i]);
//            }
//            return !cur.word.isEmpty();
//        }
//
//        public boolean startsWith(String prefix) {
//            if (prefix == null) {
//                return false;
//            }
//            if (prefix.length() == 0) {
//                return true;
//            }
//
//            char[] arr = prefix.toCharArray();
//            Trie cur = this;
//            for (int i = 0; i < arr.length; i++) {
//                if (!cur.cache.containsKey(arr[i])) {
//                    return false;
//                }
//                cur = cur.cache.get(arr[i]);
//            }
//            return true;
//        }
//    }

    public static void main(String[] args) {

    }

}
