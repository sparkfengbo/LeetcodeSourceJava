import java.util.HashSet;
import java.util.Set;

public class L000575 extends Template {

    public static void main(String[] args) {
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
