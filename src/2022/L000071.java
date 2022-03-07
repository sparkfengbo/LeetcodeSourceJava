import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class L000071 extends Template {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] paths = path.split("/");

        for (String item : paths) {
            if (item.equals(".")) {
                continue;
            } else if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (item.length() > 0) {
                stack.add(item);
            }
        }

        StringBuilder ans = new StringBuilder("/");
        while (!stack.isEmpty()) {
            ans.append(stack.poll());
            if (!stack.isEmpty()) {
                ans.append("/");
            }
        }

        return ans.toString();
    }
}
