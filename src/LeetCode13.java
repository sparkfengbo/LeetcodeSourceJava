import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {

    public static void main(String[] args) {


    }

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int ans = 0;
        for (int i = 0; i < s.length(); i++ ) {
            if (i > 0 &&  map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                ans += (map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1)));
            } else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }

}
