import datastruct.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 *
 * 给定一个N叉树，返回其节点值的后序遍历。
 *
 *
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 * https://leetcode-cn.com/static/images/problemset/NaryTreeExample.png
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class LeetCode590 {

    public static void main(String[] args) {

        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);


        List<Node> list3 = new ArrayList<>();
        list3.add(node5);
        list3.add(node6);


        Node node3 = new Node(3, list3);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);

        List<Node> list1 = new ArrayList<>();
        list1.add(node3);
        list1.add(node2);
        list1.add(node4);

        Node root1 = new Node(1, list1);

        System.out.println(postorder(root1));
    }



    /**
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                result.addAll(postorder(root.children.get(i)));
            }
        }
        result.add(root.val);
        return result;
    }
}
