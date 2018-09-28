import java.util.ArrayList;
import java.util.List;

/**
 * 转换成小写字母
 *
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 */
public class LeetCode709 {

    public static void main(String[] args) {
//        //97
//        System.out.println((int)'a');
//
//        //122
//        System.out.println((int)'z');
//
//        //65
//        System.out.println((int)'A');
//
//        //90
//        System.out.println((int)'Z');


        System.out.println(toLowerCase("LOVELY"));
    }

    public static String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            int num = (int)c;
            if (num >= 65 && num <= 90) {
                sb.append((char)(num + 32));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
