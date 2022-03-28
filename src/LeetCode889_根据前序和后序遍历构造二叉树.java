import com.sun.tools.corba.se.idl.InterfaceGen;
import datastruct.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode889_根据前序和后序遍历构造二叉树 {

    public static void main(String[] args) {
//        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(result.val);
//
//        TreeNode result2 = buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
//        System.out.println(result2.val);
    }

    class Solution {
        int n;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            n = pre.length;
            for (int i = 0; i < n; i++) {
                map.put(post[i], i);
            }
            return myBuildTree(pre, post, 0, n - 1, 0, n - 1);
        }

        private TreeNode myBuildTree(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight) {
            if (preLeft > preRight || preLeft >= n) {
                return null;
            }
            int preRootIndex = preLeft;
            TreeNode root = new TreeNode(pre[preRootIndex]);
            int leftChildRootIndex = preRootIndex + 1;
            //注意边界条件 leftChildRootIndex <= preRight
            if (leftChildRootIndex < n && leftChildRootIndex <= preRight) {
                int leftChildPostIndex = map.get(pre[leftChildRootIndex]);
                int leftChildSize = leftChildPostIndex - postLeft + 1;
                root.left = myBuildTree(pre, post, preRootIndex + 1, preRootIndex + leftChildSize, postLeft, leftChildPostIndex);
                root.right = myBuildTree(pre, post, preRootIndex + leftChildSize + 1, preRight, leftChildPostIndex + 1, postRight - 1);
            }
            return root;
        }
    }

}
