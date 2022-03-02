package 程序员面试金典;

import datastruct.ListNode;

public class L0301 {
    public static void main(String[] args) {
        System.out.println();

    }
    class TripleInOne {
        private int[] nums;
        private int[] size;
        private int stackSize;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            this.nums = new int[stackSize * 3];
            this.size = new int[3];
        }

        public void push(int stackNum, int value) {
            if (size[stackNum] >= stackSize) {
                return;
            }
            size[stackNum]++;
            int index = stackNum * stackSize + size[stackNum] - 1;
            nums[index] = value;
        }

        public int pop(int stackNum) {
            if (size[stackNum] <= 0) {
                return -1;
            }
            int index = stackNum * stackSize + size[stackNum] - 1;
            size[stackNum]--;
            return nums[index];
        }

        public int peek(int stackNum) {
            if (size[stackNum] <= 0) {
                return -1;
            }
            int index = stackNum * stackSize + size[stackNum] - 1;
            return nums[index];
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] == 0;
        }
    }
}
