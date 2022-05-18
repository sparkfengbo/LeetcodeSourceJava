package 剑指Offer;

import datastruct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Offer28 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
               return true;
            }
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode A, TreeNode B) {
            if (A == null && B == null) {
                return true;
            } else if (A != null && B != null) {
                if (A.val != B.val) {
                    return false;
                }
                return isMirror(A.left, B.right) && isMirror(A.right, B.left);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {

    }


}
