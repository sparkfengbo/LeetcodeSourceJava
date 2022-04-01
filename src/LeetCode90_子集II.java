import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90_子集II {

    public static void main(String[] args) {

    }

    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backTrace(nums, 0, new ArrayList<>());
            return res;
        }

        public void backTrace(int[] nums, int index, List<Integer> path){
            res.add(new ArrayList<>(path));
            for(int i = index; i < nums.length; ++i){
                //剔除重复元素
                if(i != index && nums[i] == nums[i - 1]){
                    continue;
                }
                path.add(nums[i]);
                backTrace(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    class Solution_Iter {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                boolean flag = true;
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                            flag = false;
                            break;
                        }
                        t.add(nums[i]);
                    }
                }
                if (flag) {
                    ans.add(new ArrayList<Integer>(t));
                }
            }
            return ans;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subsets-ii/solution/zi-ji-ii-by-leetcode-solution-7inq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution_dfs {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            dfs(false, 0, nums);
            return ans;
        }


        /**
         * 考虑数组 [1,2,2]，选择前两个数，或者第一、三个数，都会得到相同的子集。
         *
         * 也就是说，对于当前选择的数 x，若前面有与其相同的数 y，且没有选择 y，此时包含 x 的子集，必然会出现在包含 y 的所有子集中。
         *
         * 我们可以通过判断这种情况，来避免生成重复的子集。
         *
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/subsets-ii/solution/zi-ji-ii-by-leetcode-solution-7inq/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param choosePre
         * @param cur
         * @param nums
         */
        public void dfs(boolean choosePre, int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            dfs(false, cur + 1, nums);
            if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
                return;
            }
            t.add(nums[cur]);
            dfs(true, cur + 1, nums);
            t.remove(t.size() - 1);
        }
    }

}
