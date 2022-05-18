package 剑指Offer;

import datastruct.TreeNode;

public class Offer67 {
    class Solution {
        public int strToInt(String str) {
//            if (str == null || str.length() == 0) {
//                return 0;
//            }
//            char[] arr = str.toCharArray();
//            boolean sign = false;
//            int start = 0;
//            for (int i = 0; i < arr.length; i++) {
//                char c = arr[i];
//                if (c == '+' || c == '-') {
//                    sign = c == '-';
//                    start = i + 1;
//                    break;
//                } else if (c >= '0' && c <= '9') {
//                    start = i;
//                    break;
//                } else if (c == ' ') {
//                    continue;
//                } else {
//                    return 0;
//                }
//            }
//
//            int r = 0;
//            for (int i = start; i < arr.length; i++) {
//                char c = arr[i];
//                if (c < '0' || c > '9') {
//                    break;
//                }
//                r *= 10;
//
//                if (sign) {
//                    r -= c - '0';
//                    //负数
//                    if(r >= 0) {
//                        return Integer.MIN_VALUE;
//                    }
//                } else {
//                    r += c - '0';
//
//                    //正数
//                    if(r < 0) {
//                        return Integer.MAX_VALUE;
//                    }
//                }
//            }
//            return r;

            if (str.length() == 0) {
                return 0;
            }

            boolean symbol = false;
            int startIndex = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    continue;
                } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                    startIndex = i +1;
                    if (str.charAt(i) == '-') {
                        symbol = true;
                    }
                    break;
                } else if (str.charAt(i) >= '0' || str.charAt(i) <= '9') {
                    startIndex = i ;
                    break;
                } else {
                    return 0;
                }
            }

            int endIndex = str.length();
            for (int i = startIndex; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    continue;
                } else {
                    endIndex = i ;
                    break;
                }
            }

            int ans = 0;
            for (int i = endIndex - 1; i >= startIndex; i--) {
                if (symbol) {
                    int tmp = (int) ((str.charAt(i) - '0') * Math.pow(10, endIndex - 1 - i));
                    ans -= tmp;
                    if (ans > 0) {
                        ans = Integer.MIN_VALUE;
                        break;
                    }
                } else {
                    int tmp = (int) ((str.charAt(i) - '0') * Math.pow(10, endIndex - 1 - i));
                    ans += tmp;
                    if (ans < 0) {
                        ans = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
            return  ans;
        }
    }

    public static void main(String[] args) {

    }
}
