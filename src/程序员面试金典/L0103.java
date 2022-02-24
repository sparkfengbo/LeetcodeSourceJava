package 程序员面试金典;

import java.util.HashMap;
import java.util.Map;

public class L0103 {

    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c;
            if ((c = S.charAt(i)) == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }

return sb.toString();
    }

}
