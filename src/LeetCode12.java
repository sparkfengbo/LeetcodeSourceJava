import java.util.HashMap;
import java.util.Map;

public class LeetCode12 {

    public static void main(String[] args) {


    }


    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public String intToRoman_bad(int num) {
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

        StringBuilder ans = new StringBuilder();

        int M = num / 1000;
        for (int i = 0; i < M; i++) {
            ans.append("M");
        }
        num %= 1000;

        int CM = num / 900;
        for (int i = 0; i < CM; i++) {
            ans.append("CM");
        }
        num %= 900;

        int D = num / 500;
        if (D >= 1) {
            ans.append("D");
            num %= 500;
            int C = num / 100;
            for (int i = 0; i < C; i++) {
                ans.append("C");
            }
            num %= 100;
        } else {
            int CD = num / 400;
            if (CD >= 1) {
                ans.append("CD");
                num %= 400;
            }
            int C = num / 100;
            for (int i = 0; i < C; i++) {
                ans.append("C");
            }
            num %= 100;
        }

        int XC = num / 90;
        for (int i = 0; i < XC; i++) {
            ans.append("XC");
        }
        num %= 90;

        int L = num / 50;
        if (L >= 1) {
            ans.append("L");
            num %= 50;
            int X = num / 10;
            for (int i = 0; i < X; i++) {
                ans.append("X");
            }
            num %= 10;
        } else {
            int XL = num / 40;
            if (XL >= 1) {
                ans.append("XL");
                num %= 40;
            }
            int  X= num / 10;
            for (int i = 0; i < X; i++) {
                ans.append("X");
            }
            num %= 10;
        }


        int IX = num / 9;
        for (int i = 0; i < IX; i++) {
            ans.append("IX");
        }
        num %= 9;

        int V = num / 5;
        if (V >= 1) {
            ans.append("V");
            num %= 5;
            int I = num / 1;
            for (int i = 0; i < I; i++) {
                ans.append("I");
            }
        } else {
            int IV = num / 4;
            if (IV >= 1) {
                ans.append("IV");
                num %= 4;
            }
            int I = num / 1;
            for (int i = 0; i < I; i++) {
                ans.append("I");
            }
        }
        return  ans.toString();
    }
}
