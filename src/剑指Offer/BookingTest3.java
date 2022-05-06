package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class BookingTest3 {
    static class Result {
        /*
         * Complete the 'autoCorrectSuggestions' function below.
         *
         * The function is expected to return a STRING_ARRAY.
         * The function accepts following parameters:
         *  1. STRING input
         *  2. STRING_ARRAY destinations
         */

        public static List<String> autoCorrectSuggestions(String input, List<String> destinations) {
            List<String> res = new ArrayList<>();
            int n = input.length();
            int currentDiff = Integer.MAX_VALUE;
            for (String s : destinations) {
                if (s.length() != n) {
                    continue;
                }
                int diff = diffLength(input, s, currentDiff);
                if (diff < currentDiff) {
                    currentDiff = diff;
                    res.clear();
                }
                if (diff == currentDiff) {
                    res.add(s);
                }
            }
            return res;
        }

        private static int diffLength(String input, String b, int max) {
            if (input.length() != b.length()) {
                return Integer.MAX_VALUE;
            }
            int diff = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != b.charAt(i)) {
                    diff++;
                }
                if (diff > max) {
                    return Integer.MAX_VALUE;
                }
            }
            return diff;
        }

    }

    public static void main(String[] args) {
        Result result = new Result();
        List<String> arr = new ArrayList<>();
        arr.add("bali");
        arr.add("malta");
        arr.add("palma");
        arr.add("paris");
        Result.autoCorrectSuggestions("nalga", arr);
        System.out.println( Character.isAlphabetic('Å'));
    }


}
