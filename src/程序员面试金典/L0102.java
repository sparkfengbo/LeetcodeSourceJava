package 程序员面试金典;

import java.util.*;

public class L0102 {


    private static class Node {
        char c;
        int cnt;

        public Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = getCountMap(s1);
        Map<Character, Integer> map2 = getCountMap(s2);
        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())  ) {
                return false;
            }
            if (map2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCountMap(String s) {
        Map<Character, Integer> ans = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (ans.containsKey(c)) {
                int value = ans.get(c);
                ans.put(c, ++value);
            } else {
                ans.put(c, 1);
            }
        }
        return ans;
    }

}
