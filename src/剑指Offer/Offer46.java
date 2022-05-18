package 剑指Offer;

public class Offer46 {
    class Solution {
        int result = 0;
        public int translateNum(int num) {
            String n = String.valueOf(num);
            dfs(n, 0, n.length());
            return result;
        }

        void dfs(String n, int start, int end) {
            if (start == end) {
                result++;
                return;
            }

            if (start + 1 <= n.length()) {
                int code = Integer.parseInt(n.substring(start, start + 1));
                if (code >= 0 && code <= 9) {
                    dfs(n, start + 1, end);
                }
            }

            if (start + 2 <= n.length()) {
                int code = Integer.parseInt(n.substring(start, start + 2));
                if (code >= 10 && code <= 25) {
                    dfs(n, start + 2, end);
                }
            }
        }
    }
    public static void main(String[] args) {

    }


}
