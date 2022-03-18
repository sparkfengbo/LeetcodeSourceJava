import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode869 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.reorderedPowerOf2(16));
    }


    //和47题很像
    class Solution_leetcode {
        boolean[] vis;

        public boolean reorderedPowerOf2(int n) {
            char[] nums = Integer.toString(n).toCharArray();
            Arrays.sort(nums);
            vis = new boolean[nums.length];
            return backtrack(nums, 0, 0);
        }

        public boolean backtrack(char[] nums, int idx, int num) {
            if (idx == nums.length) {
                return isPowerOfTwo(num);
            }
            for (int i = 0; i < nums.length; ++i) {
                // 不能有前导零
                if ((num == 0 && nums[i] == '0') || vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])) {
                    continue;
                }
                vis[i] = true;
                if (backtrack(nums, idx + 1, num * 10 + nums[i] - '0')) {
                    return true;
                }
                vis[i] = false;
            }
            return false;
        }

        public boolean isPowerOfTwo(int n) {
            return (n & (n - 1)) == 0;
        }
    }


    static class Solution {
        public boolean reorderedPowerOf2(int n) {
            if (n == 0) {
                return false;
            }
            char[] s = String.valueOf(n).toCharArray();
            Arrays.sort(s);
            while (true) {
                if (s[0] != '0' && isPow2(Integer.parseInt(String.valueOf(s)))) {
                    return true;
                }
                char[] arr = getNext(s);
                if (arr == null) {
                    if (isPow2(Integer.parseInt(String.valueOf(s)))) {
                        return true;
                    }
                    break;
                }
                s = arr;
            }

            return false;
        }

        private boolean isPow2(int n) {
            int count = 0;
            int i = 0;
            while (n >> i != 0) {
                if ((n >> i & 1) == 1) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
                i++;
            }
            return count == 1;
        }

        private char[] getNext(char[] s) {
            int length = s.length;
            int index = -1;
            for (int i = length - 1; i > 0; i--) {
                if (s[i - 1] < s[i]) {
                    index = i - 1;
                    break;
                }
            }
            if (index == -1) {
                return null;
            }

            int index2 = -1;
            for (int i = length - 1; i > index; i--) {
                if (s[i] > s[index]) {
                    index2 = i;
                    break;
                }
            }
            swap(s, index, index2);
            reverse(s, index + 1);
            return s;
        }

        private void reverse(char[] s, int i) {
            int left = i;
            int right = s.length - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
        }

        private void swap(char[] s, int i, int j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }

}
