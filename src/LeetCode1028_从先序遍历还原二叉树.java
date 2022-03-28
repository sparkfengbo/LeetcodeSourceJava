import datastruct.TreeNode;

public class LeetCode1028_从先序遍历还原二叉树 {

    public static void main(String[] args) {
//        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(result.val);
//
//        TreeNode result2 = buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
//        System.out.println(result2.val);
    }


    /**
     * 作者：code-go
     * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/solution/code-go-jian-dan-de-di-gui-qiu-jie-fang-jef6q/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public TreeNode recoverFromPreorder(String traversal) {
            return recursion(traversal, 0, traversal.length() - 1);
        }

        /**
         * 以递归方式，从字符串 traversal 中恢复二叉树
         *
         * @param traversal 字符串
         * @param start     开始下标，包含 start
         * @param end       结束下标，包含 end
         * @return 二叉树
         */
        private TreeNode recursion(String traversal, int start, int end) {
            if (start > end) {
                return null;
            }
            // 根节点
            int val = 0;
            while (start < traversal.length() && Character.isDigit(traversal.charAt(start))) {
                val = val * 10 + Character.getNumericValue(traversal.charAt(start));
                start++;
            }
            TreeNode root = new TreeNode(val);
            // 确定左子树的开始下标
            // level : 根节点后紧跟着的节点深度， ls : 左子树的开始下标
            int level = 0, ls = start;
            while (start < traversal.length() && traversal.charAt(ls) == '-') {
                level++;
                ls++;
            }
            // 找右子树的开始下标
            int rs = findNodeIndex(traversal, ls, end, level);

            // 递归
            if (rs < 0) {
                // 没有右子树
                root.left = recursion(traversal, ls, end);
            } else {
                root.left = recursion(traversal, ls, rs - level - 1);
                root.right = recursion(traversal, rs, end);
            }
            return root;
        }

        /**
         * 在字符串 traversal 中，找到深度为 level 的节点开始下标
         *
         * @param traversal 字符串
         * @param start     查找范围的起点，包含 start
         * @param end       查找范围的终点，包含 end
         * @param level     深度, levn >= 1
         * @return 开始下标，如果没找到，就返回-1
         */
        private int findNodeIndex(String traversal, int start, int end, int level) {
            int len = 0;
            boolean flag = false;
            for (; start < end; start++) {
                while (traversal.charAt(start) == '-') {
                    start++;
                    len++;
                }
                // 找到 level 个 '-'
                if (len == level) {
                    flag = true;
                    break;
                } else {
                    len = 0;
                }
            }
            if (flag) {
                return start;
            } else {
                return -1;
            }
        }
    }

}
