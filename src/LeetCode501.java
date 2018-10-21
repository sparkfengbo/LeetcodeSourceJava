import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class LeetCode501 {

    public static void main(String[] args) {

        LeetCode501 leetCode501 = new LeetCode501();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        leetCode501.findMode(root);

    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        List<Integer> result = preOrder(root);

        for (int i = 0; i < result.size(); i++) {
            if (hashMap.containsKey(result.get(i))) {
                int count = hashMap.get(result.get(i));
                count++;
                hashMap.put(result.get(i), count);
            } else {
                hashMap.put(result.get(i), 1);
            }
        }

        Integer[] collections = hashMap.values().toArray(new Integer[0]);

        Arrays.sort(collections);

        List<Integer> reuslt = new ArrayList<>();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() == collections[collections.length - 1]) {
                reuslt.add((Integer) entry.getKey());
            }
        }

        int[] intarrya = new int[reuslt.size()];

        for (int i = 0 ; i < reuslt.size(); i++) {
            intarrya[i] = reuslt.get(i);
        }
        return intarrya;
    }

    public List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;

        List<Integer> result = new ArrayList<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode tmp = stack.pollFirst();
            if (tmp != null) {
                result.add(tmp.val);
                if (tmp.right != null) {
                    node = tmp.right;
                }
            }
        }
        return result;
    }

}
