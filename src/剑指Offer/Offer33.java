package 剑指Offer;

import datastruct.ListNode;

public class Offer33 {

    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return true;
            }
            int m = postorder.length;
            return myVerify(postorder, 0, m - 1);
        }

        private boolean myVerify(int[] postorder, int start, int end) {
            if (start >= end) {
                return true;
            }

            int root = postorder[end];
            int rightStart = -1;
            for (int i = start; i < end; i++) {
                if (postorder[i] > root) {
                    rightStart = i;
                    break;
                }
            }
            if (rightStart != -1) {
                for (int i = rightStart; i < end; i++) {
                    if (postorder[i] < root) {
                        return false;
                    }
                }
            }
            if (rightStart == -1) {
                return myVerify(postorder, start, end - 1);
            } else {
                return myVerify(postorder, start, rightStart - 1) && myVerify(postorder, rightStart, end - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(
                s.verifyPostorder(new int[]{4, 6, 12, 8, 16, 14, 10}));
    }
}
