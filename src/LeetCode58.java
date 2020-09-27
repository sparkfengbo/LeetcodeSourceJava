public class LeetCode58 {

    public static void main(String[] args) {
        System.out.print("");
    }

    public int lengthOfLastWord(String s) {
        char[] c = s.trim().toCharArray();
        for (int i = c.length - 1; i>= 0; i--) {
            if (c[i] == ' ') {
                return c.length - i - 1;
            }
        }
        return 0;

//        int end = s.length() - 1;
//        while(end >= 0 && s.charAt(end) == ' ') end--;
//        if(end < 0) return 0;
//        int start = end;
//        while(start >= 0 && s.charAt(start) != ' ') start--;
//        return end - start;
//
//        作者：guanpengchn
//        链接：https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
