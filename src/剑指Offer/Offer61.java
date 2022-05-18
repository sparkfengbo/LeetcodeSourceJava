package 剑指Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Offer61 {
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int zeroCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroCount++;
                    continue;
                }
                if (i + 1 < nums.length) {
                    int next = nums[i + 1];
                    if (next > nums[i] + 1) {
                        zeroCount -= next - nums[i] - 1;
                        if (zeroCount < 0) {
                            return false;
                        }
                    } else if (next == nums[i]) {
                        return false;
                    }
                }
            }
            return true;

        }
    }



//    作者：jyd
//    链接：https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        public boolean isStraight(int[] nums) {
            Set<Integer> repeat = new HashSet<>();
            int max = 0, min = 14;
            for(int num : nums) {
                if(num == 0) continue; // 跳过大小王
                max = Math.max(max, num); // 最大牌
                min = Math.min(min, num); // 最小牌
                if(repeat.contains(num)) return false; // 若有重复，提前返回 false
                repeat.add(num); // 添加此牌至 Set
            }
            return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
        }
    }


    public static void main(String[] args) {

    }


}
