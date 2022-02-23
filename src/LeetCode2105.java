public class LeetCode2105 {

    public static void main(String[] args) {
        System.out.println(minimumRefill(new int[]{2,2,3,3}, 5, 5));
    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int n = plants.length;
        int leftA = capacityA, leftB = capacityB;
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            if (i == j) {
                if (leftA >= leftB) {
                    if (leftA < plants[i]) {
                        ans++;
                    }
                } else  {
                    if (leftB < plants[i]) {
                        ans++;
                    }
                }
                break;
            }

            if (leftA >= plants[i]) {
                leftA -= plants[i];
            } else {
                leftA = capacityA - plants[i];
                ans++;
            }

            if (leftB >= plants[j]) {
                leftB -= plants[j];
            } else {
                leftB = capacityB - plants[j];
                ans++;
            }
        }
        return ans;

    }

}
