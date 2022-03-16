import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode1253 {

    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//
//        System.out.println(maxSubArray(new int[]{-1}));

        Solution solution = new Solution();

//        System.out.println(solution.reconstructMatrix(2, 1, new int[]{1, 1, 1}));
//        System.out.println(solution.reconstructMatrix(2, 3, new int[]{2, 2,  1, 1}));
        System.out.println(solution.reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
    }

    //确定有多少个2需要平分。同时收集信息，是否能分
    //在能分的情况下，由upper先承担1此时，lower承担0。直至upper无法负担1时，lower承担。
    //https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/solution/java-1253-zhong-gou-2-xing-er-jin-zhi-ju-ao91/
    static class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<List<Integer>> ans = new ArrayList<>();
            int sum = 0;
            int two = 0;
            for (int num : colsum) {
                two += num == 2 ? 1 : 0;
                sum += num;
            }
            // 满足如下条件，无法分
            if (sum != upper + lower || two > upper || two > lower) {
                return ans;
            }
            int len = colsum.length;
            int one = upper - two;// upper可以承担的1的数量
            List<Integer> listUpper = new ArrayList<>();
            List<Integer> listLower = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int num = colsum[i];
                if (num == 2) {
                    listUpper.add(1);
                    listLower.add(1);
                } else if (num == 1) {
                    if (one > 0) {
                        listUpper.add(1);
                        listLower.add(0);
                        one -= 1;// 承担数量减少1
                    } else {
                        listUpper.add(0);
                        listLower.add(1);
                    }
                } else {
                    listUpper.add(0);
                    listLower.add(0);
                }
            }
            ans.add(listUpper);
            ans.add(listLower);
            return ans;
        }
    }
}
