import com.sun.deploy.panel.TreeBuilder;
import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode99 {
    class Solution {
        List<TreeNode> treeInorderList = new ArrayList<>();
        List<Integer> valInorderList = new ArrayList<>();

        public void recoverTree(TreeNode root) {
            inOrder(root);
            int index1 = -1, index2 = -1;
            for (int i = 0; i < valInorderList.size(); i++) {
                if (i > 0 && valInorderList.get(i) < valInorderList.get(i - 1)) {
                    if (index1 == -1) {
                        index1 = i - 1;
                    } else if (index2 == -1) {
                        index2 = i;
                    }
                }

                if (index1 != -1 && index2 != -1 ) {
                    break;
                }
            }

            if (index2 == -1) {
                index2 = index1 + 1;
            }

            TreeNode node1 = treeInorderList.get(index1);
            TreeNode node2 = treeInorderList.get(index2);
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }

        private void inOrder(TreeNode node) {
            if (node.left != null) {
                inOrder(node.left);
            }
            treeInorderList.add(node);
            valInorderList.add(node.val);
            if (node.right != null) {
                inOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {

    }
}
