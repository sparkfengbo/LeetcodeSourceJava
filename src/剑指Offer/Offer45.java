package 剑指Offer;

public class Offer45 {

    //
//    作者：jyd
//    链接：https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            quickSort(strs, 0, strs.length - 1);

            StringBuilder res = new StringBuilder();
            for (String s : strs)
                res.append(s);
            return res.toString();
        }

        void quickSort(String[] strs, int l, int r) {
            if (l >= r) return;
            int i = l, j = r;
            String tmp = strs[i];
            String pivot = strs[l];
            while (i < j) {
                while ((strs[j] + pivot).compareTo(pivot + strs[j]) >= 0 && i < j) j--;
                while ((strs[i] + pivot).compareTo(pivot + strs[i]) <= 0 && i < j) i++;
                tmp = strs[i];
                strs[i] = strs[j];
                strs[j] = tmp;
            }
            strs[i] = pivot;
            strs[l] = tmp;
            quickSort(strs, l, i - 1);
            quickSort(strs, i + 1, r);
        }
    }

    public static void main(String[] args) {

    }


}
