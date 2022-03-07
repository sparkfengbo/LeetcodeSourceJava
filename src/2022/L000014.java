import java.util.HashMap;
import java.util.Map;

public class L000014 extends Template {

    public static void main(String[] args) {

    }


    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length <= 0) {
            return "";
        } else if (length == 1) {
            return strs[0];
        }
        int endIndex = 0;
        while (true) {
            if (endIndex >= strs[0].length()) {
                break;
            }
            char pivot = strs[0].charAt(endIndex);
            boolean match = true;
            for (int i = 1; i < length; i++) {
                if (endIndex < strs[i].length() && strs[i].charAt(endIndex) == pivot) {
                    continue;
                } else {
                    match = false;
                    break;
                }
            }
            if (!match) {
                break;
            }
            endIndex++;
        }
        return endIndex == 0 ? "" : strs[0].substring(0, endIndex);
    }

}
