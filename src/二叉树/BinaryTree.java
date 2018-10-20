package 二叉树;

import datastruct.TreeNode;

import java.util.*;

public class BinaryTree {


    public static void main(String[] args) {

    }

    /**
     * 递归插入方法
     */
    public TreeNode insertRecur(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertRecur(root.left, val);
        } else {
            root.right = insertRecur(root.right, val);
        }

        return root;
    }

    /**
     * 迭代插入方法
     */
    public TreeNode insertIter(TreeNode root, int val) {

        TreeNode node = new TreeNode(val);

        if (root == null) {
            return node;
        }

        TreeNode current = root, parent = null;

        while (current != null) {
            parent = current;
            if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (parent.val > val) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return root;
    }

    /**
     * 二叉搜索树最小的节点
     *
     * @param root
     * @return
     */
    public TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        }

        return findMin(root.left);
    }

    /**
     * 二叉搜索树最大的节点
     *
     * @param root
     * @return
     */
    public TreeNode findMax(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return root;
        }

        return findMax(root.right);
    }

    /**
     * 【递归】查找二叉树的节点
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchNOrderecur(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchNOrderecur(root.left, val);
        } else {
            return searchNOrderecur(root.right, val);
        }
    }

    /**
     * 【迭代】查找二叉树的节点
     *
     * @param root
     * @param val
     * @return index 0 parent  index 1 current
     */
    public TreeNode[] searchNodeIter(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode current = root, parent = null;

        while (current != null && current.val != val) {
            parent = current;
            if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return new TreeNode[]{parent, current};
    }


    /**
     * 删除节点
     * <p>
     * 1 删除叶子节点，直接删除
     * 2 删除的节点有两个子节点，将左子树的最大节点替换到待删除节点，递归删除左子树的最大节点
     * 3 删除的节点有一个子节点，将孩子替换自己即可
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode deleteNodeIter(TreeNode root, int val) {

        TreeNode[] searchResult = searchNodeIter(root, val);
        TreeNode parent = searchResult[0], current = searchResult[1];

        if (current == null) {
            //value not found
            return root;
        }
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
                return null;
            } else {
                if (parent.left == current) {
                    current = null;
                    parent.left = null;
                } else {
                    current = null;
                    parent.right = null;
                }
            }
        } else if (current.left != null && current.right != null) {
            TreeNode leftMax = findMax(current.left);
            deleteNodeIter(current, leftMax.val);
            current.val = leftMax.val;
        } else {
            if (root != current) {
                TreeNode node = current.left == null ? current.right : current.left;
                if (current == parent.left) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            } else {
                root = current;
                return root;
            }
        }
        return root;
    }


    /**
     * 二叉树节点个数
     *
     * @param root
     * @return
     */
    public int sizeOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
    }

    /**
     * 二叉树的高度
     *
     * @param root
     * @return
     */
    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 前序遍历-递归
     *
     * @return
     */
    public List<Integer> preOrderRecur(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        result.addAll(preOrderRecur(root.left));
        result.addAll(preOrderRecur(root.right));

        return result;
    }

    /**
     * 中序遍历-递归
     *
     * @return
     */
    public List<Integer> inOrderRecur(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        result.addAll(inOrderRecur(root.left));
        result.add(root.val);
        result.addAll(inOrderRecur(root.right));

        return result;
    }

    /**
     * 后序遍历-递归
     *
     * @return
     */
    public List<Integer> postOrderRecur(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        result.addAll(postOrderRecur(root.left));
        result.addAll(postOrderRecur(root.right));
        result.add(root.val);

        return result;
    }

    /**
     * 层序遍历-递归
     *
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        Deque<TreeNode> childNodeDeque = new ArrayDeque<>();

        nodeDeque.add(root);
        while (!nodeDeque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!nodeDeque.isEmpty()) {
                TreeNode node = nodeDeque.poll();
                level.add(node.val);
                if (node.left != null) {
                    childNodeDeque.add(node.left);
                }

                if (node.right != null) {
                    childNodeDeque.add(node.right);
                }
            }
            result.add(level);
            nodeDeque.addAll(childNodeDeque);
            childNodeDeque.clear();
        }

        return result;
    }

    /**
     * 前序遍历-迭代
     *
     * @return
     */
    public List<Integer> preOrderIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodeStack = new ArrayDeque<>();

        TreeNode node = root;

        while (node != null || !nodeStack.isEmpty()) {

            while (node != null) {
                nodeStack.push(node);
                result.add(node.val);
                node = node.left;
            }

            TreeNode tmp = nodeStack.pollFirst();
            if (tmp != null) {
                node = tmp.right;
            }
        }

        return result;
    }


    /**
     * 中序遍历-迭代
     *
     * @return
     */
    public List<Integer> inOrderIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodeStack = new ArrayDeque<>();

        TreeNode node = root;

        while (node != null || !nodeStack.isEmpty()) {

            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            TreeNode tmp = nodeStack.pollFirst();
            if (tmp != null) {
                result.add(tmp.val);
                node = tmp.right;
            }
        }

        return result;
    }

    /**
     * 后序遍历-迭代
     *
     * @return
     */
    public List<Integer> postOrderIter(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> nodeDeque1 = new ArrayDeque<>();
        Deque<TreeNode> nodeDeque2 = new ArrayDeque<>();

        nodeDeque1.push(root);

        TreeNode node;

        while (!nodeDeque1.isEmpty()) {
            node = nodeDeque1.poll();
            nodeDeque2.push(node);

            if (node.left != null) {
                nodeDeque1.push(node.left);
            }

            if (node.right != null) {
                nodeDeque1.push(node.right);
            }
        }

        while (!nodeDeque2.isEmpty()) {
            node = nodeDeque2.poll();
            result.add(node.val);
        }

        return result;
    }


}
