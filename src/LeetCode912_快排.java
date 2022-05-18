
public class LeetCode912_快排 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca", "cba"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);

                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length()) {
                        return stringBuilder.toString();
                    }

                    if (strs[j].charAt(i) != c) {
                        return stringBuilder.toString();
                    }
                }
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }
    }

}
