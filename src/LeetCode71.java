import utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode71 {

    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!item.isEmpty() && !item.equals(".")) stack.push(item);
        }
        String res = "";
        for (String d : stack) res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }

    public static String simplifyPath(String path) {

        Deque<String> pathStack = new ArrayDeque<>();

        int N = path.length();
        int fast = 1;
        boolean end = false;
        for (int slow = 1; slow < N && fast < N && !end; ) {
            fast = path.indexOf("/", slow);
            String dir;
            if (fast != -1) {
                dir = path.substring(slow, fast);
            } else {
                end = true;
                dir = path.substring(slow);
            }

            if (dir.equals(".")) {

            } else if (dir.equals("..")) {
                pathStack.pollLast();
            } else if (!dir.equals("")) {
                pathStack.addLast(dir);
            }
            slow = fast + 1;
        }

        StringBuilder sb = new StringBuilder();

        if (pathStack.isEmpty()) {
            return "/";
        } else {
            while (!pathStack.isEmpty()) {
                sb.append("/").append(pathStack.removeFirst());
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
//        ///home
        Utils.println(simplifyPath("/home/"));
        // "/"
        Utils.println(simplifyPath("/../"));
        //"/home/foo"
        Utils.println(simplifyPath("/home//foo/"));
        // /c
        Utils.println(simplifyPath("/a/./b/../../c/"));
        // /c
        Utils.println(simplifyPath("/a/../../b/../c//.//"));
        // /a/b/c
        Utils.println(simplifyPath("/a//b////c/d//././/.."));

    }
}
