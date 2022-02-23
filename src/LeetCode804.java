import datastruct.TreeNode;

import java.util.*;

public class LeetCode804 {

    public static void main(String[] args) {

    }

    public int uniqueMorseRepresentations(String[] words) {

        String[] morse = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        Set<Integer> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }
            set.add(sb.toString().hashCode());
        }
        return set.size();
    }
}
