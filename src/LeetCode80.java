public class LeetCode80 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int j = 1, count = 1;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] == nums[i - 1]) {
                count += 1;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(test));
    }


//    public static int removeDuplicates(int[] nums) {
//        if (nums.length <= 2)
//            return nums.length;
//
//        int index = 2;
//        for (int i = 2; i < nums.length; i++){
//            if (nums[i] != nums[index - 2])
//                nums[index++] = nums[i];
//        }
//        return index;
//    }
}
