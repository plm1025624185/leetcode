package easy;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class N_aryTreePostorderTraversal {

//    public List<Integer> postorder(Node root) {
//        List<Integer> array = new ArrayList<>();
//        traversal(root, array);
//        return array;
//    }
//
//    public void traversal(Node node, List<Integer> list){
//        if (node != null) {
//            if (node.children != null) {
//                for (Node child : node.children) {
//                    traversal(child, list);
//                }
//            }
//            list.add(node.val);
//        }
//    }

//    public List<Integer> postorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        _traversal(result, root);
//        return result;
//    }
//
//    private void _traversal(List<Integer> list, Node node) {
//        if (node == null) return;
//        for (Node child : node.children) {
//            _traversal(list, child);
//        }
//        list.add(node.val);
//    }

    /**
     * 使用循环
     * @param root
     * @return
     */
//    public List<Integer> postorder(Node root) {
//        Deque<Node> deque = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
//        deque.addFirst(root);
//        while (!deque.isEmpty()) {
//            Node node = deque.removeFirst();
//            if (node == null) continue;
//            list.add(node.val);
//            for (Node child : node.children) deque.addFirst(child);
//        }
//        Collections.reverse(list);
//        return list;
//    }

    /**
     * 使用递归
     * @param root
     * @return
     */
//    public List<Integer> postorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        _postorder(list, root);
//        return list;
//    }
//
//    private void _postorder(List<Integer> list, Node node) {
//        if (node == null) return;
//        for (Node n : node.children) {
//            _postorder(list, n);
//        }
//        list.add(node.val);
//    }

    /**
     * 使用栈
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        Deque<Node> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();
            if (node == null) continue;
            list.add(node.val);
            List<Node> nodeList = node.children;
            for (Node n : nodeList) {
                deque.addFirst(n);
            }
        }
        Collections.reverse(list);
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }
}
