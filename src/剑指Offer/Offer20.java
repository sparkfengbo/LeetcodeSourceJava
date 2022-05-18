package 剑指Offer;

import datastruct.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Offer20 {
    class Solution {
        public boolean isNumber(String s) {
            int m = s.length();
            if (m == 0) {
                return false;
            }

            Map<Integer, Map<Character, Integer>> map = new HashMap<>();
            int state = 0;
            for (int i = 0; i <= 8; i++) {
                map.put(i, new HashMap<>());
            }
            map.get(0).put(' ', 0);
            map.get(0).put('+', 1);
            map.get(0).put('-', 1);
            map.get(0).put('.', 2);
            map.get(0).put('N', 3);

            map.get(1).put('.', 2);
            map.get(1).put('N', 3);

            map.get(2).put('N', 4);

            map.get(3).put('.', 4);
            map.get(3).put('N', 3);
            map.get(3).put('e', 5);
            map.get(3).put('E', 5);
            map.get(3).put(' ', 7);

            map.get(4).put('N', 4);
            map.get(4).put('e', 5);
            map.get(4).put('E', 5);
            map.get(4).put(' ', 7);


            map.get(5).put('+', 8);
            map.get(5).put('-', 8);
            map.get(5).put('N', 6);

            map.get(6).put('N', 6);
            map.get(6).put(' ', 7);

            map.get(7).put(' ', 7);

            map.get(8).put('N', 6);

            Set<Character> alphabet = new HashSet<>();
            alphabet.add('.');
            alphabet.add(' ');
            alphabet.add('+');
            alphabet.add('-');
            alphabet.add('e');
            alphabet.add('E');
            for (int i = 0; i < m; i++) {
                char c = s.charAt(i);
                boolean isLegal =  Character.isDigit(c) ||alphabet.contains(c);
                if (!isLegal) {
                    return false;
                }
                char key = Character.isDigit(c) ? 'N' : c;
                if (!map.get(state).containsKey(key)) {
                    return false;
                } else {
                    state = map.get(state).get(key);
                }
            }
            return state == 7 || state == 3 || state == 4|| state == 6   ;
        }
    }

    public static void main(String[] args) {

    }


}
