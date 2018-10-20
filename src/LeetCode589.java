import datastruct.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N叉树的前序遍历
 *
 * 给定一个N叉树，返回其节点值的前序遍历。
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
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class LeetCode589 {

    public static void main(String[] args) {

//        datastruct.Node node5 = new datastruct.Node(5, null);
//        datastruct.Node node6 = new datastruct.Node(6, null);
//
//
//        List<datastruct.Node> list3 = new ArrayList<>();
//        list3.add(node5);
//        list3.add(node6);
//
//
//        datastruct.Node node3 = new datastruct.Node(3, list3);
//        datastruct.Node node2 = new datastruct.Node(2, null);
//        datastruct.Node node4 = new datastruct.Node(4, null);
//
//        List<datastruct.Node> list1 = new ArrayList<>();
//        list1.add(node3);
//        list1.add(node2);
//        list1.add(node4);
//
//        datastruct.Node root1 = new datastruct.Node(1, list1);



        Node root2 = new Node(1, new ArrayList<>());
        Node node2 = new Node(10, new ArrayList<>());
        Node node5 = new Node(3, new ArrayList<>());
        root2.children.add(node2);
        root2.children.add(node5);


        Node node3 = new Node(5, new ArrayList<>());
        Node node4 = new Node(0, new ArrayList<>());
        node2.children.add(node3);
        node2.children.add(node4);


        Node node6 = new Node(6, new ArrayList<>());
        node5.children.add(node6);

        //[1,10,5,0,3,6]

        System.out.println(preorder1(root2));

        System.out.println(preorder(root2));
    }


    /**
     * 迭代
     *
     * 参考了 https://blog.csdn.net/romeo12334/article/details/81451698
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Deque<Node> nodeStack = new ArrayDeque<>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.poll();
            result.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    nodeStack.push(node.children.get(i));
                }
            }
        }

        return result;
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> preorder1(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        result.add(root.val);

        if (root.children != null) {

            for (int i = 0; i < root.children.size(); i++) {
                result.addAll(preorder1(root.children.get(i)));
            }
        }

        return result;
    }
}
