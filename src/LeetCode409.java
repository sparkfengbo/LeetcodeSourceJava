import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LeetCode409 {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abccccdd"));
        //983
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>(52);


        //对字母出现的次数计数
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer value = map.get(c);
            if (value != null) {
                value++;
                map.put(c, value);
            } else {
                map.put(c, 1);
            }
        }

        Integer[] collections = map.values().toArray(new Integer[0]);

        //降序排列
        Arrays.sort(collections, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        //偶数直接加，最大奇数相加，其他的奇数 减1 后相加
        int result = 0;
        boolean isAdd = false;
        for (int i = 0; i < collections.length; i++) {
            if (collections[i] % 2 == 0 ) {
                result += collections[i];
            } else {
                if (!isAdd){
                    result += collections[i];
                    isAdd = true;
                } else {
                    result += (collections[i] - 1);
                }
            }
        }

        return result;
    }
}
