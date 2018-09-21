/**
 * 最长公共前缀
 * <p>
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LeetCode14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca", "cba"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);

                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length()) {
                        return stringBuilder.toString();
                    }

                    if (strs[j].charAt(i) != c) {
                        return stringBuilder.toString();
                    }
                }
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }
    }

}
