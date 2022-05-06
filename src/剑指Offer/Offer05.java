package 剑指Offer;

import datastruct.ListNode;

public class Offer05 {

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }


    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            for (Character c : arr) {
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
