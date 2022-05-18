package 剑指Offer;

import datastruct.ListNode;
import datastruct.TreeNode;

public class Offer26 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            if (A.val == B.val) {
                boolean match = isMatch(A, B);
                if (match) return true;
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isMatch(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null) {
                return false;
            }
            if (A.val != B.val) {
                return false;
            }

            return isMatch(A.left, B.left) && isMatch(A.right, B.right);
        }
    }

    public static void main(String[] args) {

    }


}
