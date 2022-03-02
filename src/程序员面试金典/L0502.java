package 程序员面试金典;

public class L0502 {
    public static void main(String[] args) {
        System.out.println(16 >> 32);
        System.out.println(16 >> 31 >> 1);
    }

    public String printBin(double num) {
        StringBuilder ans = new StringBuilder("0.");
        while (num != 0) {
            num *= 2;
            if (num >= 1) {
                ans.append("1");
                num -= 1;
            } else {
                ans.append("0");
            }
            if (ans.length() > 32) {
                return "ERROR";
            }
        }
        return ans.toString();
    }
}
