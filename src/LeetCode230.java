import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode230 {

    public static void main(String[] args) {


    }

    class Solution {
        int k;
        int ans = -1;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            inorder(root);
            return ans;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            if (--k < 0) {
                return;
            }
            if (k == 0) {
                ans = root.val;
                return;
            }
             inorder(root.right);
        }
    }

}
