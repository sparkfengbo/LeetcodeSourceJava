import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 键盘行
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 * https://leetcode-cn.com/static/images/problemset/keyboard.png
 *
 * 示例1:
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 注意:
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 */
public class LeetCode500 {

    public static void main(String[] args) {
        System.out.println(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}).toString());
    }

    public static String[] findWords(String[] words) {
        HashMap<Character, Integer> characters = new HashMap(26);

        characters.put('Q', 1);
        characters.put('W', 1);
        characters.put('E', 1);
        characters.put('R', 1);
        characters.put('T', 1);
        characters.put('Y', 1);
        characters.put('U', 1);
        characters.put('I', 1);
        characters.put('O', 1);
        characters.put('P', 1);

        characters.put('A', 2);
        characters.put('S', 2);
        characters.put('D', 2);
        characters.put('F', 2);
        characters.put('G', 2);
        characters.put('H', 2);
        characters.put('J', 2);
        characters.put('K', 2);
        characters.put('L', 2);

        characters.put('Z', 3);
        characters.put('X', 3);
        characters.put('C', 3);
        characters.put('V', 3);
        characters.put('B', 3);
        characters.put('N', 3);
        characters.put('M', 3);

        List<String> result = new ArrayList<>();

        for (int i = 0 ; i < words.length; i++) {
            String upperCase = words[i].toUpperCase();
            int line = -1;

            for (int j = 0; j < upperCase.length(); j++) {
                Character c = upperCase.charAt(j);
                if (j == 0) {
                    line = characters.get(c);
                }

                if (line != characters.get(c)) {
                    break;
                }

                if (j == upperCase.length() - 1) {
                    result.add(words[i]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
