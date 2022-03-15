import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum4(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combine(4, 2));
    }

    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {

            return ans;
        }
    }

}
