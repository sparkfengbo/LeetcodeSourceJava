import utils.Utils;

public class LeetCode167 {

    public static final void main(String[] args) {

        {
            int[] r = twoSum(new int[]{2,7,11,15}, 9);
            System.out.println(r[0]);
            System.out.println(r[1]);
        }
        {
            int[] r = twoSum(new int[]{-1, 0}, -1);
            System.out.println(r[0]);
            System.out.println(r[1]);
        }
        {
            int[] r = twoSum(new int[]{2,3,4}, 6);
            System.out.println(r[0]);
            System.out.println(r[1]);
        }
        {
            int[] r = twoSum(new int[]{0, 0, 3, 4}, 0);
            System.out.println(r[0]);
            System.out.println(r[1]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int slow = 0, fast = n - 1;

        while (slow < fast) {
//            if (slow < n - 2 && numbers[slow] == numbers[slow + 1]) {
//                slow++;
//                continue;
//            }
//            if (fast >= 1 && numbers[fast] == numbers[fast - 1]) {
//                fast--;
//                continue;
//            }

            int sum = numbers[slow] + numbers[fast];
            if (sum == target) {
                return new int[]{slow + 1, fast  +1};
            } else if (sum > target) {
                fast--;
            } else {
                slow++;
            }
        }
        return new int[]{};
    }

}
