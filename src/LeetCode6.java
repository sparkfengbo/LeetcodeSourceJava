
public class LeetCode6 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convert("abcdef", 1));

    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder ans = new StringBuilder();
            int step = 2 * numRows - 2;
            for (int i = 0; i < numRows && i < s.length(); i++) {
                int s1 = step - i * 2;
                int s2 = step - s1;
                int j = i;
                boolean selectFirstStep = s1 != 0;
                while (j < s.length()) {
                    ans.append(s.charAt(j));
                    j += selectFirstStep ? s1 : s2;
                    if (s1 != 0 && s2 != 0) {
                        selectFirstStep = !selectFirstStep;
                    }
                }
            }
            return ans.toString();
        }
    }
}
