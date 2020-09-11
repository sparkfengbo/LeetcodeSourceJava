import utils.Utils;

public class LeetCode28 {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int res = -1;

        int l = needle.length();
        int n = haystack.length();

        for (int pn = 0; pn < n - l + 1; pn++) {
            if (haystack.charAt(pn) == needle.charAt(0)) {
                //进入匹配
                int currentLen = 1;
                for(int current = 1; current < l; current++) {
                    if (haystack.charAt(pn + current) == needle.charAt(currentLen)) {
                        currentLen++;
                    } else {
                        break;
                    }
                }
                if (currentLen == l) {
                    return pn;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        Utils.println(strStr("hello", "ll"));
//        Utils.println(strStr("aaaaa", "bba"));
        Utils.println(strStr("a", "a"));
    }
}
