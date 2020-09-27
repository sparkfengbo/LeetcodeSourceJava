import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

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
//        System.out.println(isValid("()"));

        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        } else if (s.length() == 1) {
            return false;
        }

        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c =='{' || c == '[') {
                characters.push(c);
            } else if(c == ')' || c=='}' || c == ']'){
                if (!characters.empty()  && ( (c ==')' && characters.pop() == '(')
                        || (c=='}' && characters.pop() =='{')
                        || (c==']' && characters.pop() =='['))) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (!characters.isEmpty()) {
            return false;
        }

        return true;
    }
}
