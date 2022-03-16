import java.util.ArrayList;
import java.util.List;

public class LeetCode57 {

    public static void main(String[] args) {
//        System.out.print("");
//
//        int[][] res = insert(new int[][]{
//                {1, 5},
//        }, new int[]{0, 0});
//
////        int[][] res = insert(new int[][]{
////                {1, 3},
////
////                {6, 9},
////        }, new int[]{2, 5});


        System.out.println();
    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int left = newInterval[0];
            int right = newInterval[1];
            boolean placed = false;
            List<int[]> ansList = new ArrayList<int[]>();
            for (int[] interval : intervals) {
                if (interval[0] > right) {
                    // 在插入区间的右侧且无交集
                    if (!placed) {
                        ansList.add(new int[]{left, right});
                        placed = true;
                    }
                    ansList.add(interval);
                } else if (interval[1] < left) {
                    // 在插入区间的左侧且无交集
                    ansList.add(interval);
                } else {
                    // 与插入区间有交集，计算它们的并集
                    left = Math.min(left, interval[0]);
                    right = Math.max(right, interval[1]);
                }
            }
            if (!placed) {
                ansList.add(new int[]{left, right});
            }
            int[][] ans = new int[ansList.size()][2];
            for (int i = 0; i < ansList.size(); ++i) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }
    }

//    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int m = intervals.length;
//
//        if (m == 0) {
//            return new int[][]{
//                    newInterval
//            };
//        }
//
//        List<int[]> list = new ArrayList<>(m);
//
//        int left = newInterval[0];
//        int right = newInterval[1];
//        int index = 0;
//        while (index < m) {
//            int[] curr = intervals[index];
//            if (index == 0 && curr[0] > newInterval[1]) {
//                list.add(newInterval);
//                index++;
//                continue;
//            }
//
//            if (index == m - 1 && curr[1] < newInterval[0]) {
//                list.add(newInterval);
//                index++;
//                continue;
//            }
//
//            if (curr[1] < left || curr[0] > right) {
//                list.add(curr);
//                index++;
//                continue;
//            } else {
//                left = Math.min(left, curr[0]);
//                while (index < m) {
//                    int[] inner = intervals[index];
//                    if (inner[0] > right) {
//                        break;
//                    } else {
//                        right = Math.max(right, inner[1]);
//                    }
//                    index++;
//                }
//                list.add(new int[]{left, right});
//            }
//        }
//
//
//        int[][] res = new int[list.size() ][];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }
}
