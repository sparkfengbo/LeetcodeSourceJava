import java.util.HashMap;
import java.util.Map;

public class L000013 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        System.out.println(romanToInt("MCMXCIV"));
    }



    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i + 1 < n && map.get(s.charAt(i + 1)) > map.get(c)) {
                ans += (map.get(s.charAt(i + 1)) - map.get(c));
                i += 1;
            } else {
                ans += map.get(c);
            }
        }
        return ans;
    }

}
