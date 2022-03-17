import utils.Utils;

import java.util.*;

public class LeetCode17 {
    class Solution {
        Map<Character, List<Character>> map = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            int length = digits.length();
            if (length == 0) {
                return ans;
            }
            map.put('2', new ArrayList<Character>() {{
                add('a');
                add('b');
                add('c');
            }});
            map.put('3', new ArrayList<Character>() {{
                add('d');
                add('e');
                add('f');
            }});
            map.put('4', new ArrayList<Character>() {{
                add('g');
                add('h');
                add('i');
            }});
            map.put('5', new ArrayList<Character>() {{
                add('j');
                add('k');
                add('l');
            }});
            map.put('6', new ArrayList<Character>() {{
                add('m');
                add('n');
                add('o');
            }});
            map.put('7', new ArrayList<Character>() {{
                add('p');
                add('q');
                add('r');
                add('s');
            }});
            map.put('8', new ArrayList<Character>() {{
                add('t');
                add('u');
                add('v');
            }});
            map.put('9', new ArrayList<Character>() {{
                add('w');
                add('x');
                add('y');
                add('z');
            }});
            dfs(digits, new StringBuilder(), 0, ans);
            return ans;
        }

        private void dfs(String digits, StringBuilder path, int index, List<String> ans) {
            if (index == digits.length()) {
                ans.add(path.toString());
                return;
            }

            char digit = digits.charAt(index);
            List<Character> ch = map.get(digit);
            for (int i = 0; i < ch.size(); i++) {
                path.append(ch.get(i));
                dfs(digits, path, index + 1, ans);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }


    public static void main(String[] args) {

    }
}
