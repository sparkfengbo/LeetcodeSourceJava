/**
 * 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class LeetCode557 {

    public static void main(String[] args) {

        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc"));
    }

    public static String reverseWords(String s) {
        String[] str = s.split(" ");

        //test
//        for (String t : str) {
//            System.out.println(t);
//        }

        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < str.length; i++) {
            String t = str[i];
            for (int j = t.length() - 1; j >= 0; j--) {
                stringBuilder.append(t.charAt(j));
            }

            if (i != str.length - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
