import java.util.*;

/**
 * 反转字符串
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class LeetCode344 {

    public static void main(String[] args) {

        System.out.println(reverseString("hello").endsWith(reverseString1("hello")));

    }

    public static String reverseString(String s) {
        if (s == null || s.equals("")) {
            return "";
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        return sb.toString();
    }


    public static String reverseString1(String s) {
        if (s == null || s.equals("")) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    public static String reverseString2(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i =0 ; i < stack.size(); i++) {

        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
