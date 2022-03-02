package 剑指Offer;

public class Offer58II {

    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        if (n == length) {
            return s;
        }

        n %= length;
        char[] ans = new char[length];
        char[] str = s.toCharArray();

        for (int i = n; i < length + n; i++) {
            int index = i % length;
            ans[i - n] = str[index];
        }
        return new String(ans);
    }

    public String reverseLeftWords2(String s, int n) {
        int length = s.length();
        if (n == length) {
            return s;
        }
        n %= length;
        String tmp = s + s;
        return tmp.substring(n, n + length);
    }

    public String reverseLeftWords3(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}
