import java.util.HashSet;

public class LeetCode1103 {

    public static void main(String[] args) {
        int[] rest = distributeCandies(7, 4);
        System.out.print("");
    }

    public static int[] distributeCandies(int candies, int num_people) {

        int[] ans = new int[num_people];

        int start = 1;

        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies > start) {
                    candies -= start;
                    ans[i] += start++;
                } else {
                    ans[i] += candies;
                    return ans;
                }
            }
        }

        return ans;
    }
}
