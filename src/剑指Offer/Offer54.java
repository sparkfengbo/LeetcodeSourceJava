package 剑指Offer;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer54 {
    class Solution {
        List<Integer> inorderList = new ArrayList<>();
        public int kthLargest(TreeNode root, int k) {
            inorder(root);
            int size = inorderList.size();
            return inorderList.get(size - k);
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            inorderList.add(root.val);
            inorder(root.right);
        }
    }

    class Solution_ {
        List<Integer> inorderReverseList = new ArrayList<>();
        int k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            inorder_reverse(root);
            return inorderReverseList.get(k - 1);
        }


        //右 根 左
        private void inorder_reverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (inorderReverseList.size() >= k) {
                return;
            }
            inorder_reverse(root.right);
            inorderReverseList.add(root.val);
            inorder_reverse(root.left);
        }
    }

//    //
//    作者：jyd
//    链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        int res, k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        void dfs(TreeNode root) {
            if(root == null) return;
            dfs(root.right);
            if(k == 0) return;
            if(--k == 0) res = root.val;
            dfs(root.left);
        }
    }

    public static void main(String[] args) {

    }


}
