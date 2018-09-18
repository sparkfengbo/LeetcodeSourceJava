import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));

        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        } else if (s.length() == 1) {
            return false;
        }

        Deque<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('{') || c.equals('[')) {
                characters.push(c);
            } else if (c.equals(')') || c.equals('}') || c.equals(']')) {
                Character first = characters.peekFirst();
                if (first != null) {
                    if ((c.equals(')') && characters.pollFirst().equals('('))
                            || (c.equals('}') && characters.pollFirst().equals('{'))
                            || (c.equals(']') && characters.pollFirst().equals('['))) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        if (!characters.isEmpty()) {
            return false;
        }

        return true;
    }
}
