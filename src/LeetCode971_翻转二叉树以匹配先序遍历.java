import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode971_翻转二叉树以匹配先序遍历 {

    public static void main(String[] args) {
//        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(result.val);
//
//        TreeNode result2 = buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
//        System.out.println(result2.val);
    }


    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/solution/fan-zhuan-er-cha-shu-yi-pi-pei-xian-xu-bian-li-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        List<Integer> flipped;
        int index;
        int[] voyage;

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            flipped = new ArrayList();
            index = 0;
            this.voyage = voyage;

            dfs(root);
            if (!flipped.isEmpty() && flipped.get(0) == -1) {
                flipped.clear();
                flipped.add(-1);
            }

            return flipped;
        }

        public void dfs(TreeNode node) {
            if (node != null) {
                if (node.val != voyage[index++]) {
                    flipped.clear();
                    flipped.add(-1);
                    return;
                }

                if (index < voyage.length && node.left != null &&
                        node.left.val != voyage[index]) {
                    flipped.add(node.val);
                    dfs(node.right);
                    dfs(node.left);
                } else {
                    dfs(node.left);
                    dfs(node.right);
                }
            }
        }
    }

}
