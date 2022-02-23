import java.util.PriorityQueue;

public class LeetCode2079 {

    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[]{2, 2, 3, 3}, 5));
    }

    public static int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int left = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (left >= plants[i]) {
                res += 1;
                left -= plants[i];
            } else {
                left = capacity -  plants[i];
                res += 2 * i + 1;
            }
        }

        return res;
    }

}
