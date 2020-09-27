public class LeetCode65 {

    public static void main(String[] args) {


    }

    //https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
    public static boolean isNumber(String s) {
        int state = 0;

        /**
         *  finals({0, 0, 0, 1, 0, 1, 1, 0, 1});
         *
         *  return finals[state]
         *
         *  和下面的等价，只不过将顺序调换了，运算能快一些
         *
         */
        int finalState  = 0b101101000;

        int[][] transfer = new int[][]{
                { 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}
        };
        char[] ss = s.toCharArray();
        for(int i=0; i < ss.length; ++i) {
            int id = transform(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finalState & (1 << state)) > 0;
    }

    public static int transform(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }
}
