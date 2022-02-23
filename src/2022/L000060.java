import java.util.ArrayList;
import java.util.Arrays;

public class L000060 extends Template {

    public static void main(String[] args) {
        System.out.println(cantor(new int[]{3, 4, 1, 5, 2}, 5));
        System.out.println(inverse_cantor(5, 62));
        System.out.println(getPermutation(5, 62));
    }


    /**
     * [1,2,3,4,5] n = 5, 34152是第62个升序排列
     *
     * https://baike.baidu.com/item/%E5%BA%B7%E6%89%98%E5%B1%95%E5%BC%80/7968428?fr=aladdin
     *
     * X = An(n - 1)! + An-1(n-2)! + .....+ A1*0
     * 0 <= Ai <= i  1 <= i <= n
     * Ai表示原数的第i位在当前未出现的元素中排在第几个(小于Ai并且还没出现过的数字的个数)
     * @param nums
     * @param n
     * @return
     */
    static int cantor(int[] nums, int n) {
        assert nums.length == n;

        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            ans += count * factorial[n - i - 1];
            count = 0;
        }
        return ans + 1;
    }

    static String inverse_cantor(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder ans = new StringBuilder();

        ArrayList<Integer> array = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            array.add(i);
        }

        k--;
        for (int i = 0; i < n; i++) {
            int index = k / factorial[n - i - 1] + 1;
            ans.append(array.get(index));
            array.remove(index);
            k %= factorial[n - i - 1];
        }
        return ans.toString();
    }


    /**
     * 深度搜索+剪枝
     * https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
     * @param n
     * @param k
     * @return
     */
    static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path, used, n, k, factorial);
        return path.toString();
    }

    private static void dfs(int level, StringBuilder path, boolean[] used, int n, int k, int[] factorial) {
        if (level == n) return;

        //第一次是（n-1）!
        int cnt = factorial[n - 1 - level];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(level + 1, path, used, n, k, factorial);
            return;
        }
    }


}
