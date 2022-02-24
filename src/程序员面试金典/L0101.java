package 程序员面试金典;

import java.util.HashSet;
import java.util.Set;

public class L0101 {

    public static void main(String[] args) {
        System.out.println((int)('A'));
        System.out.println((int)('B'));
        System.out.println((int)('Z'));
        System.out.println((int)('a'));
        System.out.println((int)('~'));

    }


        public boolean isUnique_bit(String astr) {
        int mark = 0;
        for (char c : astr.toCharArray()) {
            int bit = c - 'a';
            if ((mark & (1 << bit)) != 0) {
                return false;
            }
            mark |= (1 << bit);
        }
        return true;
    }

    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }

        return true;
    }

}
